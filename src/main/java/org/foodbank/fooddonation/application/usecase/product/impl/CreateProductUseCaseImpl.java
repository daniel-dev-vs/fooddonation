package org.foodbank.fooddonation.core.usecase.product.impl;

import org.foodbank.fooddonation.core.usecase.product.CreateProductUseCase;
import org.foodbank.fooddonation.core.usecase.product.dto.CreateProductInput;
import org.foodbank.fooddonation.core.usecase.product.dto.CreateProductOuput;
import org.foodbank.fooddonation.core.gateway.product.CreateProductGateway;
import org.foodbank.fooddonation.core.entity.product.Product;
import org.foodbank.fooddonation.core.entity.product.ProductInvalidException;

import java.time.LocalDateTime;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final CreateProductGateway createGatewayProduct;

    public CreateProductUseCaseImpl(CreateProductGateway createGatewayProduct){
        this.createGatewayProduct = createGatewayProduct;
    }

    @Override
    public CreateProductOuput createProduct(CreateProductInput input) throws ProductInvalidException {
        Product product = new Product(input.name(), input.unity(), LocalDateTime.now());
        product.validateProduct();
        Product newProduct = createGatewayProduct.save(product);
        return new CreateProductOuput(newProduct.getId(), newProduct.getName(), newProduct.getUnity(), newProduct.getCreatedAt());
    }
}
