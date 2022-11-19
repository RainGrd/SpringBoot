package com.bdqn;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/30 16:57
 * FileName: Generator
 * Description:
 */
public class Generator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator=new AutoGenerator();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("drg1224605");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/bdqn?serverTimezone=UTC");
        autoGenerator.setDataSource(dataSourceConfig);


        /*生成代码生成器*/
        autoGenerator.execute();
    }
}
