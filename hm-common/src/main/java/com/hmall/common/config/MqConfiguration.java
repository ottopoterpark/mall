package com.hmall.common.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author unique
 */
@Configuration
public class MqConfiguration {

    @Bean
    public MessageConverter messageConverter()
    {
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        messageConverter.setCreateMessageIds(true);
        return messageConverter;
    }
}