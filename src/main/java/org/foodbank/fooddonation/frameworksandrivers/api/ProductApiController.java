package org.foodbank.fooddonation.frameworksandrivers.api;


import org.foodbank.fooddonation.frameworksandrivers.api.request.CreateProductRequest;
import org.foodbank.fooddonation.frameworksandrivers.api.request.CreateProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/products")
public class ProductApiController {

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request){


        return ResponseEntity.ok(new CreateProductResponse(1L, "","", LocalDateTime.now()));
    }

}
