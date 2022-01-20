package com.provider.service;

import com.api.Bean.Lock;

import com.provider.dao.LockDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class LockService {
    @Autowired
    private LockDao lockDao;
    public int lock(int id){
        int n = lockDao.queryLock(id);
        if(n>0){
            return 0;
        }
        Lock lock = new Lock();
        lock.setId(id);
        lock.setStatus(1);
        lock.setStartTime(new Date());
        lock.setEndTime(new Date());
        return lockDao.lock(lock);
    }
    public int unLock(int id){
        int n = lockDao.queryLock(id);
        if(n==0){
            return 1;
        }
        return lockDao.unLock(id);
    }
}
