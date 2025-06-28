package org.foodbank.fooddonation.application.usecase.product.Impl;

import org.foodbank.fooddonation.interfaceadapters.controller.CreateProductUseCase;
import org.foodbank.fooddonation.application.usecase.product.dto.CreateProductInput;
import org.foodbank.fooddonation.application.usecase.product.dto.CreateProductOuput;
import org.foodbank.fooddonation.interfaceadapters.gateway.product.CreateGatewayProduct;
import org.foodbank.fooddonation.enterprise.entity.product.Product;
import org.foodbank.fooddonation.enterprise.entity.product.ProductInvalidException;

import java.time.LocalDateTime;

public class ProductUseCaseImpl implements CreateProductUseCase {

    private CreateGatewayProduct createGatewayProduct;

    private ProductUseCaseImpl(CreateGatewayProduct createGatewayProduct){
        this.createGatewayProduct = createGatewayProduct;
    }

    @Override
    public CreateProductOuput createProduct(CreateProductInput input) throws ProductInvalidException {
        Product product = new Product(input.name(), input.unity(), LocalDateTime.now());
        product.validateProduct();
        Product newProduct = createGatewayProduct.save(product);
        return new CreateProductOuput(newProduct.getId(), newProduct.getName(), newProduct.getUnity(), newProduct.getCreateAt());
    }
}
