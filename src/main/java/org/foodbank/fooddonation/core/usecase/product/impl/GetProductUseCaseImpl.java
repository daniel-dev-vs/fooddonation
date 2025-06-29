package org.foodbank.fooddonation.core.usecase.product.impl;

import org.foodbank.fooddonation.core.usecase.product.dto.GetProductOutput;
import org.foodbank.fooddonation.core.entity.product.Product;
import org.foodbank.fooddonation.core.entity.product.ProductNotFoundException;
import org.foodbank.fooddonation.core.usecase.product.GetProductUseCase;
import org.foodbank.fooddonation.core.gateway.product.GetProductGateway;

import java.util.Collection;
import java.util.stream.Collectors;

public class GetProductUseCaseImpl implements GetProductUseCase {

    private final GetProductGateway getGatewayProduct;

    public  GetProductUseCaseImpl(GetProductGateway getGatewayProduct){
        this.getGatewayProduct =getGatewayProduct;
    }
    @Override
    public GetProductOutput getProductById(Long id) throws IllegalArgumentException,ProductNotFoundException {

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
