package com.unibuc.ordersmicroservice.controller;

import com.unibuc.ordersmicroservice.domain.Order;
import com.unibuc.ordersmicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{username}/{shoppingCartId}")
    public Order createOrder(@PathVariable(value = "shoppingCartId") String shoppingCartId,
                             @PathVariable(value = "username") String username
    ){
        log.info("Creating order for username: {}, and shopping cart id: {}", username, shoppingCartId);
        return orderService.createOrder(username, shoppingCartId);
    }
}
