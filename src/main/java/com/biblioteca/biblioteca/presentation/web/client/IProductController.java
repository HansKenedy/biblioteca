package com.biblioteca.biblioteca.presentation.web.client;

import com.biblioteca.biblioteca.application.mainmodule.dto.ProductDto;
import feign.Headers;
import feign.Param;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="product-service", url= "http://localhost:8002/")
@RequestMapping("/products")
public interface IProductController {

    @GetMapping("/getProduct/{productId}")
    @ApiOperation("Get product by ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 404, message = "PRODUCT NOT FOUND")
    })
    public ProductDto getProduct(@ApiParam(value = "This ID of the product.", example = "5", required = true)
                                 @PathVariable("productId") long productId);
}
