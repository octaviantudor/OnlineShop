package com.unibuc.ordersmicroservice.service;

import com.unibuc.ordersmicroservice.domain.Order;
import com.unibuc.ordersmicroservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public Order createOrder(String username, String shoppingCartId) {

        return orderRepository.save(Order.builder()
                        .username(username)
                        .shoppingCartId(shoppingCartId)
                .build());
    }

    public List<Order> getOrdersByUsername(String username){
        return orderRepository.findAllByUsername(username);
    }
}
