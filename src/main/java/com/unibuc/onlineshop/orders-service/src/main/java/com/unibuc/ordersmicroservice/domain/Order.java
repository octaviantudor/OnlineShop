package com.unibuc.ordersmicroservice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "id_shopping_carts" )
    private String shoppingCartId;

    @Column(name = "total_price")
    private Double price;
}
