package com.unibuc.gatewayservice.domain.order;

import lombok.Data;

@Data
public class Order {

    private Long id;

    private String username;

    private String shoppingCartId;

    private Double price;
}