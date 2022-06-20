package com.unibuc.gatewayservice.client;


import com.unibuc.gatewayservice.domain.shoppingcart.ShoppingCart;
import com.unibuc.gatewayservice.domain.shoppingcart.ShoppingCartProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@FeignClient(value = "shopping-cart-service")
public interface ShoppingCartClient {

    @RequestMapping(method = RequestMethod.POST, value = "/shopping-cart/{username}/{productId}")
    ShoppingCart addProduct(@PathVariable(value = "productId") String productId,
                            @PathVariable(value = "username") String username);

    @RequestMapping(method = RequestMethod.GET, value = "/shopping-cart/{username}")
    ShoppingCart getShoppingCartByUser(@PathVariable(value = "username") String username);

    @RequestMapping(method = RequestMethod.GET, value = "/shopping-cart/{username}/items")
    Set<ShoppingCartProduct> getShoppingCartItems(@PathVariable(value = "username") String username);

    @RequestMapping(method = RequestMethod.POST, value = "/shopping-cart/check/{username}")
    void checkShoppingCart(@PathVariable(value = "username") String username);
}
