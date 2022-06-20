package com.unibuc.gatewayservice.controller;


import com.unibuc.gatewayservice.domain.shoppingcart.ShoppingCart;
import com.unibuc.gatewayservice.domain.shoppingcart.ShoppingCartProduct;
import com.unibuc.gatewayservice.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("/{username}/{productId}")
    public ShoppingCart addProduct(@PathVariable(value = "productId") String productId,
                                   @PathVariable(value = "username") String username){
        log.info("Add product with id: {} , for username: {} ", productId, username);
        return shoppingCartService.addProductToShoppingCart(productId, username);

    }

    @GetMapping("/{username}")
    public ShoppingCart getShoppingCart(
            @PathVariable(value = "username") String username){
        log.info("Get shopping cart for username: {} ", username);
        return shoppingCartService.getShoppingCart(username);

    }

    @GetMapping("/{username}/items")
    public Set<ShoppingCartProduct> getShoppingCartItems(
            @PathVariable(value = "username") String username){
        log.info("Get shopping cart for username: {} ", username);
        return shoppingCartService.getShoppingCartItems(username);

    }

}
