package com.unibuc.itemsservice.domain.mapper;

import com.unibuc.itemsservice.domain.dto.ProductDto;
import com.unibuc.itemsservice.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryMapper categoryMapper;

    public ProductDto toDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(categoryMapper.toDto(product.getCategory()))
                .build();
    }
}
