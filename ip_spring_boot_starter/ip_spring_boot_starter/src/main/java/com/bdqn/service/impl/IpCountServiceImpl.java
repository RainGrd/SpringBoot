package com.bdqn.service.impl;

import com.bdqn.properties.IpProperties;
import com.bdqn.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/20 19:11
 * FileName: ipCountServiceImpl
 * Description:
 */
public class IpCountServiceImpl implements IpCountService {

    private Map<String, Integer> ipCountMap = new HashMap<>();
    /**
     * 当前的request对象的注入工作也使用当前的starter的工程提供自动装配
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public void count() {
        // 每次调用当前操作，就记录当前访问的IP，然后累加访问访问次数
        // 1.获取当前访问的IP地址
        String ip = httpServletRequest.getRemoteAddr();
        Integer count = ipCountMap.get(ip);
        System.out.println(ipCountMap.containsKey(ip));
        if (!ipCountMap.containsKey(ip)) {
            ipCountMap.put(ip, 1);
        } else {
            // 2.根据IP地址从Map里面取值，并递增
            ipCountMap.put(ip, count + 1);
        }
    }

    @Autowired
    private IpProperties ipProperties;

    //    @Scheduled(cron = "0/${tools.ip.cycle:5} * * * * *")
//    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * *")
    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * *")
    @Override
    public void print() {
        System.out.println("           IP访问监控");
        System.out.println(ipProperties.getModel());
        if (ipProperties.getModel().equals(IpProperties.LogModel.DETAIL.getValue())) {
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.printf("|%18s  |%5d  |%n", key, value);
            }
            System.out.println("+--------------------+-------+");
        } else if (ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())) {
            System.out.println("+-----ip-address-----+");
            for (String key : ipCountMap.keySet()) {
                System.out.printf("|%18s  |%n", key);
            }
            System.out.println("+--------------------+-------+");
        }
        if (ipProperties.getCycleReset()) {
            ipCountMap.clear();
        }
    }
}
