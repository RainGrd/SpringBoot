package com.bdqn.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/13 18:39
 * FileName: PayEndpoint
 * Description:
 */
@Component
@Endpoint(id = "pay",enableByDefault = true)
public class PayEndpoint {

    @ReadOperation
    public Object getPay(){
        Map<String,Object> payMap=new HashMap<>();
        payMap.put("level 1","3000");
        payMap.put("level 2","4000");
        payMap.put("level 3","5000");
        payMap.put("level 4","6000");
        return payMap;
    }


}
