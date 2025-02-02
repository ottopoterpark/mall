package com.hmall.api.config;

import com.hmall.api.interceptor.UserInfoFeignInterceptor;
import com.hmall.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

/**
 * @author unique
 */
public class DefaultFeignConfig {

    /**
     * OpenFeign日志级别
     *
     * @return
     */
    @Bean
    public Logger.Level feignLogLevel()
    {
        return Logger.Level.FULL;
    }

    /**
     * 微服务远程调用传递用户信息
     * @return
     */
    @Bean
    public UserInfoFeignInterceptor userInfoFeignInterceptor()
    {
        return new UserInfoFeignInterceptor();
    }
}
