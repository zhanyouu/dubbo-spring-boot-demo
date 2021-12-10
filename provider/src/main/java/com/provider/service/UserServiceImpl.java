package com.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
@Slf4j
@Service(version = "1.0.0",interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
//    @Override
    /**
     * 限流降级
     * @return
     */
    @SentinelResource(value = "getUser", blockHandler = "blockHandler",fallback = "fallBackHandler")
    public String getUser() {
        return "hello";
    }
    /**
     * 异常降级
     * @return
     */
    @SentinelResource(value = "getName",blockHandler = "blockHandler",fallback = "fallBackHandler")
    public String getName() {
        String name = null;
        if(StringUtil.isBlank(name)){
            throw new IllegalArgumentException("参数非法");
        }
        return "zhanyou";
    }
    public String fallBackHandler(){
        log.error("fallbackHandler：");
        return "服务异常，熔断降级!";
    }

    public String blockHandler(BlockException ex){
        log.error("blockHandler：" +  ex);
        return "访问过快，限流降级!";
    }
}
