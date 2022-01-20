package com.provider.dao;

import com.api.Bean.Lock;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LockDao {
    int queryLock(@Param("id") int id);

    int lock(Lock lock);

    int unLock(@Param("id") int id);
}
