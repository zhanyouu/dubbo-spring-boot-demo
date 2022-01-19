package com.provider;

import com.alibaba.csp.sentinel.init.InitExecutor;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@MapperScan(value="com.provider.dao")
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args)  {
        ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);
        // 连接到控制台，与sentinel控制台通信
//        System.setProperty("project.name",
//                context.getEnvironment().getProperty("spring.application.name","sentinel"));
//        System.setProperty("csp.sentinel.dashboard.server",
//                context.getEnvironment().getProperty("sentinel.dashboard.server","localhost:8080"));
//        InitExecutor.doInit();
    }
}
