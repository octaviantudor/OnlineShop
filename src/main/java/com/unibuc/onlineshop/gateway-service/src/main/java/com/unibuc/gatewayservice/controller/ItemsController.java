package com.unibuc.gatewayservice.controller;


import com.unibuc.gatewayservice.client.ItemsClient;
import com.unibuc.gatewayservice.domain.ProductDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemsController {

    private final ItemsClient itemsClient;

    @GetMapping
    @CircuitBreaker(name = "products", fallbackMethod = "getProductsFallBack")
    public List<ProductDto> getProducts(){
        return itemsClient.getStores();
    }

    public List<ProductDto> getProductsFallBack(Exception e){
        System.out.println("This is a fallback method!");
        return Collections.singletonList(ProductDto.builder()
                .name("mocked product").build());
    }
}
