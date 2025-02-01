package com.hmall.api.client;

import com.hmall.api.dto.ItemDTO;
import com.hmall.api.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * @author unique
 */
@FeignClient(value = "item-service",path = "/items")
public interface ItemClient {

    @GetMapping
    List<ItemDTO> queryItemByIds(@RequestParam("ids")Collection<Long> ids);

    @PutMapping("/stock/deduct")
    void deductStock(@RequestBody List<OrderDetailDTO> items);

}
