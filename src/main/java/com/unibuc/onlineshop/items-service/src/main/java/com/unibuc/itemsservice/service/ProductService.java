package com.unibuc.itemsservice.service;

import com.unibuc.itemsservice.domain.dto.ProductDto;
import com.unibuc.itemsservice.domain.mapper.ProductMapper;
import com.unibuc.itemsservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public List<ProductDto> findAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto findById(String productId) {
        return productRepository.findById(Long.valueOf(productId))
                .map(productMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found for id: " + productId));
    }


}
