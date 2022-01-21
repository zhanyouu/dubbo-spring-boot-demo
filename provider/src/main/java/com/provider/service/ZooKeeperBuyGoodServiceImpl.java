package com.provider.service;

import com.api.Bean.Order;
import com.api.service.BuyService;
import com.api.service.OrderService;
import com.api.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service(version = "4.0.0",interfaceClass = BuyService.class)
public class ZooKeeperBuyGoodServiceImpl implements BuyService {
    @Autowired
    private StockService stockService;
    @Autowired
    private OrderService orderService ;
    @Override
    public void buyGood(int id) {
        Lock lock = new ZookeeperLock();
        log.info("------------------zookeeper-------------");
        try {
            lock.getLock();
            int num = stockService.getGoodStock(id);
            log.info("商品id={},库存数量num={}",id,num);
            if(num>0){
                int res = stockService.updateGoodStock(id,1);
                if(res>0){
                    Order order = new Order();
                    order.setGoodId(id);
                    order.setDesc("商品id为"+id+"的商品");
                    orderService.insertOrder(order);
                }
            }else {
                log.info("库存不足！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }
}
