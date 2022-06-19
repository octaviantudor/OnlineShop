package com.unibuc.gatewayservice.domain;


import com.unibuc.gatewayservice.client.ItemsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/print")
public class ServiceLejer {
    @Autowired
    private ItemsClient itemsClient;

    @GetMapping
    public List<ProductDto> printChestii(){
       return  itemsClient.getStores();
    }
}
