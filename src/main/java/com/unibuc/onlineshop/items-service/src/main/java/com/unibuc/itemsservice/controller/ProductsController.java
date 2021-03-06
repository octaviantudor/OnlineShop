package com.unibuc.itemsservice.controller;

import com.unibuc.itemsservice.domain.dto.ProductDto;

import com.unibuc.itemsservice.service.ProductService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductsController {

    private final ProductService productService;

    @GetMapping
    @CircuitBreaker(name = "products", fallbackMethod = "getProductsFallBack")
    public List<ProductDto> getProducts(){
        log.info("Return all products");
        return productService.findAllProducts();
    }

    public List<ProductDto> getProductsFallBack(Exception e){
        System.out.println("This is a fallback method!");
        return Collections.singletonList(ProductDto.builder()
                .name("mocked product").build());
    }
    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable(name = "productId") String productId){
        log.info("Return product with id: {}", productId);
        return productService.findById(productId);
    }

    private ProductDto fallBackMethod(String productId, Throwable throwable){
        log.error("Executing Fallback Method For General exceptions");
        throw new RuntimeException("Service currently unavailable");
    }
}
