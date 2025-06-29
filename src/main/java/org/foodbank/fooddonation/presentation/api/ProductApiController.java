package org.foodbank.fooddonation.presentation.api;


import org.foodbank.fooddonation.core.entity.product.ProductInvalidException;
import org.foodbank.fooddonation.infrastructure.product.controller.ProductController;
import org.foodbank.fooddonation.presentation.api.request.product.CreateProductRequest;
import org.foodbank.fooddonation.presentation.api.request.product.CreateProductResponse;
import org.foodbank.fooddonation.presentation.api.request.product.GetProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductApiController {


    public ProductController productController;

    public ProductApiController( ProductController productController) {
        this.productController = productController;
    }


    @GetMapping()
    public ResponseEntity<Collection<GetProductResponse>> getProduct() {

        return ResponseEntity.ok(productController.getProducts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable Long id) {

        return ResponseEntity.ok(productController.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request) throws ProductInvalidException {

        return ResponseEntity.status(201).body(productController.createProduct(request));

    }

}
