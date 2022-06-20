package com.unibuc.shoppingcart.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_carts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping_cart")
    private Long id;

    @Column(name = "checked")
    private Boolean checked;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy="shoppingCart")
    private Set<ShoppingCartProduct> productSet;
}
