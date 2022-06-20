package com.unibuc.gatewayservice.domain.shoppingcart;

import lombok.Data;

import java.util.Set;

@Data
public class ShoppingCart {

    private Long id;
    private Boolean checked;
    private String username;
    private Set<ShoppingCartProduct> productSet;
}
