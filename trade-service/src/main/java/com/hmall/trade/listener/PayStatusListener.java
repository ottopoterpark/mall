package com.hmall.trade.listener;

import com.hmall.trade.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author unique
 */
@Component
@RequiredArgsConstructor
public class PayStatusListener {

    private final IOrderService orderService;

    /**
     * 订单支付成功异步修改交易状态
     * @param orderId
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "trade.pay.success.queue",durable = "true"),
            exchange = @Exchange(name = "pay.topic",type = ExchangeTypes.TOPIC),
            key = {"pay.success"}
    ))
    public void listenPaySuccess(Long orderId)
    {
        orderService.markOrderPaySuccess(orderId);
    }


}
