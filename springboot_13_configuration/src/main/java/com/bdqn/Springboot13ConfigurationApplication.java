package com.bdqn;

import com.bdqn.config.ServerConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;

@SpringBootApplication
@EnableConfigurationProperties({ServerConfig.class})
public class Springboot13ConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public ComboPooledDataSource dataSource(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        return comboPooledDataSource;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot13ConfigurationApplication.class, args);
        ServerConfig bean = run.getBean(ServerConfig.class);
        System.out.println(bean);
        ComboPooledDataSource comboPooledDataSource = run.getBean(ComboPooledDataSource.class);
        System.out.println(comboPooledDataSource.getUser());
    }

}
