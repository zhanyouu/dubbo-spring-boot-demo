package com.provider.service;

import com.api.service.StockService;
import com.provider.dao.StockDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
@Service(version = "1.0.0",interfaceClass = StockService.class)
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDao stockDao;

    @Override
    public int getGoodStock(int id) {
        int num = stockDao.selectGoodStock(id);
        return num;
    }

    @Override
    public int updateGoodStock(int id, int num) {
        return stockDao.updateGoodStock(id,num);
    }
}
