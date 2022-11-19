package com.bdqn;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//启用注解的方式创建注解
@EnableCreateCacheAnnotation
//开启方法缓存
@EnableMethodCache(basePackages = "com.bdqn")
public class Springboot20JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot20JetcacheApplication.class, args);
    }

}
