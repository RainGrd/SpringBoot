package com.bdqn.actuator;

import com.bdqn.utils.LocalDateTimeUtils;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/13 16:13
 * FileName: infoConfig
 * Description:
 */
@Component
public class InfoConfig implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("runTime", LocalDateTimeUtils.convertLongTimeToStringYMD(System.currentTimeMillis()));
        Map<String,Object> infoMap=new HashMap<>();
        infoMap.put("buildTime","2005");
        builder.withDetails(infoMap);
    }
}
