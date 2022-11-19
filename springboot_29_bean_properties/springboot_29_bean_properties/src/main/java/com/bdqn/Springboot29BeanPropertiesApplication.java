package com.bdqn;

import com.bdqn.bean.CartoonCatAndMouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

@SpringBootApplication(excludeName = "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration")
//@SpringBootConfiguration
//    @Configuration
//        @Component
//    @Indexed
//@EnableAutoConfiguration
//    @AutoConfigurationPackage
//        @Import(AutoConfigurationPackages.Registrar.class)
//    @Import(AutoConfigurationImportSelector.class)
//@ComponentScan(
//        excludeFilters = {@ComponentScan.Filter(
//                type = FilterType.CUSTOM,
//                classes = {TypeExcludeFilter.class}
//        ), @ComponentScan.Filter(
//                type = FilterType.CUSTOM,
//                classes = {AutoConfigurationExcludeFilter.class}
//        )}
//)
//        @Import(AutoConfigurationPackages.Registrar.class) // 设置当前配置所在的包作为扫描包，后续要针对当前的包进行扫描
//    @Import(AutoConfigurationImportSelector.class)
//@Import(CartoonCatAndMouse.class)
public class Springboot29BeanPropertiesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot29BeanPropertiesApplication.class, args);
        CartoonCatAndMouse bean = run.getBean(CartoonCatAndMouse.class);
        bean.play();
    }
}
