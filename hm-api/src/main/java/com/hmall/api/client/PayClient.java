package com.hmall.api.client;

import com.hmall.api.dto.PayOrderDTO;
import com.hmall.api.fallback.PayClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author unique
 */
@FeignClient(value = "pay-service", fallbackFactory = PayClientFallbackFactory.class,path = "/pay-orders")
public interface PayClient {
    /**
     * 根据交易订单id查询支付单
     * @param id 业务订单id
     * @return 支付单信息
     */
    @GetMapping("/biz/{id}")
    PayOrderDTO queryPayOrderByBizOrderNo(@PathVariable("id") Long id);
}
