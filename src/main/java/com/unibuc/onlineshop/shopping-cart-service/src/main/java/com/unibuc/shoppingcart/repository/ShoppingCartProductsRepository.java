package com.unibuc.shoppingcart.repository;

import com.unibuc.shoppingcart.domain.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartProductsRepository extends JpaRepository<ShoppingCartProduct, Long> {
}
