package com.unibuc.gatewayservice.service;

import com.unibuc.gatewayservice.client.OrdersClient;
import com.unibuc.gatewayservice.client.ShoppingCartClient;
import com.unibuc.gatewayservice.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrdersClient ordersClient;
    private final ShoppingCartClient shoppingCartClient;

    public Order createOrder(String username) {
        var shoppingCart = shoppingCartClient.getShoppingCartByUser(username);

        var order = ordersClient.createOrder(shoppingCart.getId().toString(), username);

        shoppingCartClient.checkShoppingCart(username);

        return order;
    }


}
