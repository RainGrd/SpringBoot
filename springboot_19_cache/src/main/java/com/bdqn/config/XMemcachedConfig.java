package com.bdqn.config;

import com.bdqn.entity.XMemcachedProperties;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 16:37
 * FileName: XMemcachedConfig
 * Description:
 */
@Configuration
public class XMemcachedConfig {

    @Autowired
    private XMemcachedProperties xMemcachedProperties;

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        MemcachedClientBuilder builder=new XMemcachedClientBuilder(xMemcachedProperties.getServers());
        builder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
        builder.setOpTimeout(xMemcachedProperties.getOpTimeOut());
        MemcachedClient memcachedClient = builder.build();
        return memcachedClient;
    }


}
