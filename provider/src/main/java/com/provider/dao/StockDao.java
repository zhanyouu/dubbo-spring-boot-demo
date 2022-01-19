package com.provider.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao {
    int selectGoodStock(@Param("id") int id);

    int updateGoodStock(@Param("id") int id,@Param("num") int num);
}