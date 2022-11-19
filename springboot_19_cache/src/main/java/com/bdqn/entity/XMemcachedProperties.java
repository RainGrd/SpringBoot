package com.bdqn.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 16:47
 * FileName: XMemcachedProperties
 * Description:
 */
@Component
@ConfigurationProperties(prefix = "memcached")
@Data
public class  XMemcachedProperties{
    private String servers;
    private int poolSize;
    private Long opTimeOut;
}
