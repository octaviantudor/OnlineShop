package com.unibuc.shoppingcart.service;

import com.unibuc.shoppingcart.domain.ShoppingCart;
import com.unibuc.shoppingcart.domain.ShoppingCartProduct;
import com.unibuc.shoppingcart.repository.ShoppingCartProductsRepository;
import com.unibuc.shoppingcart.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartProductsRepository shoppingCartProductsRepository;

    public ShoppingCart addProduct(String productId, String username) {
        var shoppingCartOptional = shoppingCartRepository.findByUsernameAndChecked(username, Boolean.FALSE);

        var shoppingCart = shoppingCartOptional.isEmpty()? shoppingCartRepository.save(ShoppingCart.builder()
                        .username(username).checked(Boolean.FALSE)
                .build()) : shoppingCartOptional.get(0);

        shoppingCartProductsRepository.save(ShoppingCartProduct.builder()
                        .productId(productId)
                        .shoppingCart(shoppingCart)
                .build());

        return shoppingCart;

    }


    public void check(String username) {

        var shoppingCartOptional = shoppingCartRepository.findByUsernameAndChecked(username, Boolean.FALSE);

        if (shoppingCartOptional.isEmpty())
            throw new RuntimeException("Nu exista shopping cart pentru username: " + username);

        var shoppingCart = shoppingCartOptional.get(0);
        shoppingCart.setChecked(Boolean.TRUE);

        shoppingCartRepository.save(shoppingCart);

    }

    public ShoppingCart getShoppingCartByUsername(String username) {
        var shoppingCartList = shoppingCartRepository.findByUsernameAndChecked(username, Boolean.FALSE);
        if (shoppingCartList.isEmpty())
            throw new RuntimeException("Nu exista shopping cart pentru username: " + username);
        return shoppingCartList.get(0);

    }

    public Set<ShoppingCartProduct> getOrderedItems(String username){

        var shoppingCartList = shoppingCartRepository.findByUsernameAndChecked(username, Boolean.TRUE);
        if (shoppingCartList.isEmpty())
            throw new RuntimeException("Nu exista shopping cart pentru username: " + username);

        return shoppingCartList.stream().map(ShoppingCart::getProductSet).flatMap(Set::stream).collect(Collectors.toSet());

    }
}
