package com.unibuc.gatewayservice.service;

import com.unibuc.gatewayservice.client.OrdersClient;
import com.unibuc.gatewayservice.client.ShoppingCartClient;
import com.unibuc.gatewayservice.domain.shoppingcart.ShoppingCart;
import com.unibuc.gatewayservice.domain.shoppingcart.ShoppingCartProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartClient shoppingCartClient;
    private final OrdersClient ordersClient;

    public ShoppingCart addProductToShoppingCart(String productId, String username) {
        return shoppingCartClient.addProduct(productId, username);
    }

    public ShoppingCart getShoppingCart(String username) {
        return shoppingCartClient.getShoppingCartByUser(username);
    }

    public Set<ShoppingCartProduct> getShoppingCartItems(String username) {
        return shoppingCartClient.getShoppingCartItems(username);
    }
}
