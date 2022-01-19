package com.consumer.controller;

import com.consumer.service.BuyGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

@Slf4j
@RestController
public class StockController {
    @Resource(name = "syncBuyGoodService")
//    @Resource(name = "mysqlBuyGoodService")
//    @Resource(name = "redisBuyGoodService")
    private BuyGoodService buyGoodService;

    @RequestMapping("/buy")
    public void getStock(@RequestParam int id){
        buyGoodService.buyGood(id);
    }
}
