package com.consumer.controller;

import com.api.service.BuyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BuyController {

//    @Reference(version = "1.0.0")
    @Reference(version = "2.0.0")
//    @Reference(version = "3.0.0")
    private BuyService buyService;
    @RequestMapping("/buy")
    public void getStock(@RequestParam int id){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buyService.buyGood(id);
    }
}
