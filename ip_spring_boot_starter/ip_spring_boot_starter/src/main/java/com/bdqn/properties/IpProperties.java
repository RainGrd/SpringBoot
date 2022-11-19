package com.bdqn.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/21 9:16
 * FileName: IpProperties
 * Description:
 */
@Component("ipProperties")
@ConfigurationProperties(prefix = "tools.ip")
@Data
public class IpProperties {
    /**
     * 日志的显示周期
     */
    private Long cycle=5L;
    /**
     * 是否周期内清空数据，默认不清楚
     */
    private Boolean cycleReset=false;

    /**
     * 日志的输出模式 detail：详细模式，simple:极简模式
     */
    private String model=LogModel.DETAIL.value;


    public enum LogModel{
        DETAIL("detail"),
        SIMPLE("simple");
        private final String value;

        LogModel(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
