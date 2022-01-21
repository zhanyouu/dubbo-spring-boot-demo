package com.provider.service;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

public class ZookeeperLock extends AbstractLock{
    private static final String SERVER_ADDR = "172.30.252.96:2181";

    protected ZkClient zkClient = new ZkClient(SERVER_ADDR);

    protected static final String PATH = "/lock";

    private CountDownLatch countDownLatch = null;
    @Override
    public boolean tryLock() {
        try {
            // 创建临时节点
            zkClient.createEphemeral(PATH);
            return true;
        } catch (Exception e) {
            // 创建失败报异常
            return false;
        }
    }

    @Override
    public void waitLock() {
        // 创建监听
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                // 释放锁，删除节点时唤醒等待的线程
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };

        // 注册监听
        zkClient.subscribeDataChanges(PATH, iZkDataListener);

        // 节点存在时，等待节点删除唤醒
        if (zkClient.exists(PATH)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 删除监听
        zkClient.unsubscribeDataChanges(PATH, iZkDataListener);
    }

    @Override
    public void unLock() {
        if (zkClient != null) {
            System.out.println("释放锁资源");
            zkClient.delete(PATH);
            zkClient.close();
        }
    }
}
