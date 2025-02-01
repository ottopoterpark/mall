package com.hmall.pay;

import com.hmall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author unique
 */
@SpringBootApplication(scanBasePackages = {"com.hmall.pay","com.hmall.common.config"})
@MapperScan(basePackages = {"com.hmall.pay.mapper"})
@EnableFeignClients(basePackages = {"com.hmall.api.client"},defaultConfiguration = DefaultFeignConfig.class)
public class PayApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(PayApplication.class);
    }
}
