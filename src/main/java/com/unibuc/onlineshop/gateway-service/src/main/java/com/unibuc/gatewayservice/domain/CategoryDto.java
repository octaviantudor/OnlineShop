package com.unibuc.gatewayservice.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
}
