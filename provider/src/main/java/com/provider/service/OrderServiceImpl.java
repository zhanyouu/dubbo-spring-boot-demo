package com.provider.service;

import com.api.Bean.Order;
import com.api.service.OrderService;
import com.provider.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
@Service(version = "1.0.0",interfaceClass = OrderService.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public int insertOrder(Order order) {
        log.info("订单信息："+order.toString());
        return orderDao.insertOrder(order);
    }
}
