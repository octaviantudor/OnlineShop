package com.unibuc.gatewayservice.domain.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private Long id;

    private String username;

    private String shoppingCartId;

    private Double price;
}