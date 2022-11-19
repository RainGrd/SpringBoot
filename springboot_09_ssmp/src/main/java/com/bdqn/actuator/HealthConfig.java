package com.bdqn.actuator;

import com.bdqn.utils.LocalDateTimeUtils;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/13 16:44
 * FileName: HealthConfig
 * Description:
 */
@Component("health")
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean condition=true;
        if (condition) {
            builder.status(Status.UP);
            builder.withDetail("runTime", LocalDateTimeUtils.convertLongTimeToStringYMD(System.currentTimeMillis()));
//            builder.up();
            Map<String,Object> infoMap=new HashMap<>();
            infoMap.put("buildTime","2005");
            builder.withDetails(infoMap);

        }else{
            builder.status(Status.DOWN);
            builder.withDetail("上线了吗?", "你做梦！");
//            builder.down();
        }

    }
}
