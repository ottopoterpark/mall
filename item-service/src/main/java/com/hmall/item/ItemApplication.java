package com.hmall.item;

import com.hmall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author unique
 */
@SpringBootApplication(scanBasePackages = {"com.hmall.item","com.hmall.common.config"})
@MapperScan(basePackages = {"com.hmall.item.mapper"})
@EnableFeignClients(basePackages = {"com.hmall.api.client"},defaultConfiguration = DefaultFeignConfig.class)
public class ItemApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(ItemApplication.class);
    }
}
