package com.hmall.api.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author unique
 */
public class DefaultFeignConfig {

    /**
     * OpenFeign日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLogLevel()
    {
        return Logger.Level.FULL;
    }
}
