package com.unibuc.gatewayservice.client;

import com.unibuc.gatewayservice.domain.order.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "orders-service")
public interface OrdersClient {

    @RequestMapping(method = RequestMethod.POST, value = "/order/{username}/{shoppingCartId}")
    Order createOrder(@PathVariable(value = "shoppingCartId") String shoppingCartId,
                      @PathVariable(value = "username") String username
    );
}
