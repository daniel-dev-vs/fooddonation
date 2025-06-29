package org.foodbank.fooddonation.application.usecase.product.impl;

import org.foodbank.fooddonation.application.usecase.product.dto.GetProductOutput;
import org.foodbank.fooddonation.enterprise.entity.product.Product;
import org.foodbank.fooddonation.enterprise.entity.product.ProductNotFoundException;
import org.foodbank.fooddonation.interfaceadapters.product.controller.GetProductUseCase;
import org.foodbank.fooddonation.interfaceadapters.product.gateway.GetGatewayProduct;

import java.util.Collection;
import java.util.stream.Collectors;

public class GetProductUseCaseImpl implements GetProductUseCase {

    private final GetGatewayProduct getGatewayProduct;

    public  GetProductUseCaseImpl(GetGatewayProduct getGatewayProduct){
        this.getGatewayProduct =getGatewayProduct;
    }
    @Override
    public GetProductOutput getProduct(Long id) {

        if(id < 1)
            throw new IllegalArgumentException("the ID should be a valid ID.");

        Product product = getGatewayProduct.getProductById(id);

        if (product == null)
            throw new ProductNotFoundException("The sent ID wasn't found any product.");

        return new GetProductOutput(product.getId(), product.getName(), product.getUnity(), product.getCreatedAt());
    }

    @Override
    public Collection<GetProductOutput> getProducts() {
        Collection<Product> products = getGatewayProduct.getProducts();
        return products.stream()
                .map(p ->
                        new GetProductOutput(
                                p.getId(),
                                p.getName()
                                , p.getUnity(),
                                p.getCreatedAt()
                        )
                )
                .collect(Collectors.toSet());
    }
}
