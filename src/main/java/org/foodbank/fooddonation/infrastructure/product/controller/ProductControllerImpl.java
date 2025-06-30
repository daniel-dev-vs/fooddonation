package org.foodbank.fooddonation.infrastructure.product.controller;

import org.foodbank.fooddonation.core.controller.product.ProductController;
import org.foodbank.fooddonation.core.entity.product.ProductInvalidException;
import org.foodbank.fooddonation.core.entity.product.ProductNotFoundException;
import org.foodbank.fooddonation.core.gateway.product.CreateProductGateway;
import org.foodbank.fooddonation.core.gateway.product.GetProductGateway;
import org.foodbank.fooddonation.core.usecase.product.CreateProductUseCase;
import org.foodbank.fooddonation.core.usecase.product.GetProductUseCase;
import org.foodbank.fooddonation.core.usecase.product.dto.CreateProductInput;
import org.foodbank.fooddonation.core.usecase.product.dto.CreateProductOuput;
import org.foodbank.fooddonation.core.usecase.product.dto.GetProductOutput;
import org.foodbank.fooddonation.core.usecase.product.impl.CreateProductUseCaseImpl;
import org.foodbank.fooddonation.core.usecase.product.impl.GetProductUseCaseImpl;
import org.foodbank.fooddonation.presentation.api.request.product.CreateProductRequest;
import org.foodbank.fooddonation.presentation.api.request.product.CreateProductResponse;
import org.foodbank.fooddonation.presentation.api.request.product.GetProductResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ProductControllerImpl implements ProductController {
    private GetProductUseCase getProductUseCase;
    private CreateProductUseCase createProductUseCase;
    private GetProductGateway getGatewayProduct;
    private CreateProductGateway createGatewayProduct;

    public ProductControllerImpl(GetProductGateway getGateway, CreateProductGateway createGateway) {

        this.getProductUseCase = new GetProductUseCaseImpl(getGateway);
        this.createProductUseCase = new CreateProductUseCaseImpl(createGateway);
    }


    @Override
    public Collection<GetProductResponse> getProducts() {
        Collection<GetProductOutput> products = getProductUseCase.getProducts();

        return products.stream()
                .map(output ->
                        new GetProductResponse(output.id(), output.name(), output.unity(), output.createAt()))
                .collect(Collectors.toSet());
    }

    @Override
    public GetProductResponse getProductById(Long id) throws IllegalArgumentException, ProductNotFoundException {
        GetProductOutput product = getProductUseCase.getProductById(id);
        return new GetProductResponse(product.id(), product.name(), product.unity(), product.createAt());
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) throws ProductInvalidException {
        CreateProductOuput output = createProductUseCase.createProduct(new CreateProductInput(request.name(), request.unity()));

        return new CreateProductResponse(output.id(),output.name(), output.unity(), output.createAt());
    }
}
