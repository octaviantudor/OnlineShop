package com.unibuc.shoppingcart.controller;


import com.unibuc.shoppingcart.domain.ShoppingCart;
import com.unibuc.shoppingcart.domain.ShoppingCartProduct;
import com.unibuc.shoppingcart.service.ShoppingCartService;
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
        return shoppingCartService.addProduct(productId, username);

    }

    @PostMapping("/check/{username}")
    public void checkShoppingCart(@PathVariable(value = "username") String username){
        log.info("Check Shopping Cart for username: {}", username);
        shoppingCartService.check(username);
    }

    @GetMapping("/{username}")
    public ShoppingCart getShoppingCartByUser(@PathVariable(value = "username") String username){
        log.info("Get shopping cart by username: {}", username);
        var shoppingCart =  shoppingCartService.getShoppingCartByUsername(username);

        shoppingCart.getProductSet().forEach(System.out::println);

        return shoppingCart;
    }

    @GetMapping("/{username}/items")
    public Set<ShoppingCartProduct> getShoppingCartItems(@PathVariable(value = "username") String username){
        log.info("Get shopping cart items by username: {}", username);
        return shoppingCartService.getOrderedItems(username);
    }
}
