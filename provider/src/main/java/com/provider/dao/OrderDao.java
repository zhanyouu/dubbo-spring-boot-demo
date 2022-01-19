package com.provider.dao;

import com.api.Bean.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    int insertOrder(Order order);
}
