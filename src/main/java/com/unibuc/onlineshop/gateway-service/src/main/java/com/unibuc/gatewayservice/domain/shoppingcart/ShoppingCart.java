package com.unibuc.gatewayservice.domain.shoppingcart;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ShoppingCart {

    private Long id;
    private Boolean checked;
    private String username;
    private Set<ShoppingCartProduct> productSet;
}
