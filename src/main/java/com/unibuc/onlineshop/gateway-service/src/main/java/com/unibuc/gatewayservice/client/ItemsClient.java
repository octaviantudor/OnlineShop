package com.unibuc.gatewayservice.client;

import com.unibuc.gatewayservice.domain.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "items-service")
public interface ItemsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<ProductDto> getStores();
}
