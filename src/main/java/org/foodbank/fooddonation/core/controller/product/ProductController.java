package org.foodbank.fooddonation.core.controller.product;

import org.foodbank.fooddonation.core.entity.product.ProductInvalidException;
import org.foodbank.fooddonation.core.entity.product.ProductNotFoundException;
import org.foodbank.fooddonation.presentation.api.request.product.CreateProductRequest;
import org.foodbank.fooddonation.presentation.api.request.product.CreateProductResponse;
import org.foodbank.fooddonation.presentation.api.request.product.GetProductResponse;

import java.util.Collection;

public interface ProductController {
    Collection<GetProductResponse> getProducts();
    GetProductResponse getProductById(Long id) throws IllegalArgumentException, ProductNotFoundException;
    CreateProductResponse createProduct(CreateProductRequest request) throws ProductInvalidException;

}
