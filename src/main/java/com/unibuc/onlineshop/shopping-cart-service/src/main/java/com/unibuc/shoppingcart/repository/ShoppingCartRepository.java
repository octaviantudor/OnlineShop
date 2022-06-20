package com.unibuc.shoppingcart.repository;

import com.unibuc.shoppingcart.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {


    List<ShoppingCart> findByUsernameAndChecked(String username, Boolean checked);

    Optional<ShoppingCart> findByUsername(String username);
}
