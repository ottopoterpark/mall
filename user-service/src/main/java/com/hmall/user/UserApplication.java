package com.hmall.user;

import com.hmall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author unique
 */
@SpringBootApplication(scanBasePackages = {"com.hmall.user","com.hmall.common.config"})
@MapperScan(basePackages = {"com.hmall.user.mapper"})
@EnableFeignClients(basePackages = {"com.hmall.api.client"},defaultConfiguration = DefaultFeignConfig.class)
public class UserApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(UserApplication.class);
    }
}
