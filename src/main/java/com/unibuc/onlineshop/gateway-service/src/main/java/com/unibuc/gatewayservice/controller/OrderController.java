package com.unibuc.gatewayservice.controller;


import com.unibuc.gatewayservice.domain.order.Order;
import com.unibuc.gatewayservice.domain.shoppingcart.ShoppingCartProduct;
import com.unibuc.gatewayservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{username}")
    public Order createOrder(@PathVariable(value = "username") String username) {
        log.info("Create order for username: {}", username);
        return orderService.createOrder(username);
    }

}
