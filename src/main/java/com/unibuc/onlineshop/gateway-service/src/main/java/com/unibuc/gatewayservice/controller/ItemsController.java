package com.unibuc.gatewayservice.controller;


import com.unibuc.gatewayservice.client.ItemsClient;
import com.unibuc.gatewayservice.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemsController {

    private final ItemsClient itemsClient;

    @GetMapping
    public List<ProductDto> getProducts(){
        return itemsClient.getStores();
    }
}
