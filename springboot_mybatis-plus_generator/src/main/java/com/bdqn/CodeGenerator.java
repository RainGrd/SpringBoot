package com.bdqn;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/30 17:01
 * FileName: CodeGenerator
 * Description:
 */
public class CodeGenerator {
    public static void main(String[] args) {
        /*1.获取代码生成器*/
        AutoGenerator autoGenerator = new AutoGenerator();
        /*2.设置数据源*/
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/bdqn?serverTimezone=UTC");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("drg1224605");
        autoGenerator.setDataSource(dataSourceConfig);
        /*设置全局配置*/
        GlobalConfig globalConfig = new GlobalConfig();
        //设置输出位置
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/springboot_11_mybatis-plus_generator/src/main/java");
        //设置生成完毕后是否打开生成代码所在的目录
        globalConfig.setOpen(false);
        //设置作者
        globalConfig.setAuthor("RainGrd");
        //设置是否覆盖原始生成的文件
        globalConfig.setFileOverride(true);
        //设置数据层接口名称 %s为占位符 指代模块名称
        globalConfig.setMapperName("%sMapper");
        //设置id生成策略
        globalConfig.setIdType(IdType.ASSIGN_ID);
        autoGenerator.setGlobalConfig(globalConfig);
        /*设置包名相关配置*/
        PackageConfig packageConfig = new PackageConfig();
        //设置生成的包名
        packageConfig.setParent("com.bdqn");
        autoGenerator.setPackageInfo(packageConfig);
        /*策略设置*/
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("t_user","t_book");
        //生成序列化ID
        strategyConfig.setEntitySerialVersionUID(true);
        //设置数据库表的前缀 模块名 = 数据库表名-前缀名 例如 User =tbl_user
        strategyConfig.setTablePrefix("t_");
        //设置是否启用rest风格
        strategyConfig.setRestControllerStyle(true);
        //设置乐观锁字段名
        strategyConfig.setVersionFieldName("version");
        //设置逻辑删除字段名
        strategyConfig.setLogicDeleteFieldName("deleted");
        //设置是否 启用lombok
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);
        /*生成代码*/
        autoGenerator.execute();
    }
}
