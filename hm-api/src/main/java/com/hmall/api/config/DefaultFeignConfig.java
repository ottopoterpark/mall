package com.hmall.api.config;

import com.hmall.api.fallback.ItemClientFallbackFactory;
import com.hmall.api.fallback.PayClientFallbackFactory;
import com.hmall.api.interceptor.UserInfoFeignInterceptor;
import feign.Logger;
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
     *
     * @return
     */
    @Bean
    public UserInfoFeignInterceptor userInfoFeignInterceptor()
    {
        return new UserInfoFeignInterceptor();
    }

    /**
     * 商品Feign客户端服务降级处理类
     *
     * @return
     */
    @Bean
    public ItemClientFallbackFactory itemClientFallbackFactory()
    {
        return new ItemClientFallbackFactory();
    }

    /**
     * 支付Feign客户端服务降级处理类
     *
     * @return
     */
    @Bean
    public PayClientFallbackFactory payClientFallbackFactory()
    {
        return new PayClientFallbackFactory();
    }
}
