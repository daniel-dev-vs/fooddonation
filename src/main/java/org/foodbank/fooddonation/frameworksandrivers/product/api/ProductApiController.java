package org.foodbank.fooddonation.frameworksandrivers.product.api;


import org.foodbank.fooddonation.application.usecase.product.dto.CreateProductInput;
import org.foodbank.fooddonation.application.usecase.product.dto.CreateProductOuput;
import org.foodbank.fooddonation.application.usecase.product.dto.GetProductOutput;
import org.foodbank.fooddonation.enterprise.entity.product.ProductInvalidException;
import org.foodbank.fooddonation.frameworksandrivers.product.api.request.CreateProductRequest;
import org.foodbank.fooddonation.frameworksandrivers.product.api.request.CreateProductResponse;
import org.foodbank.fooddonation.frameworksandrivers.product.api.request.GetProductResponse;
import org.foodbank.fooddonation.interfaceadapters.product.controller.CreateProductUseCase;
import org.foodbank.fooddonation.interfaceadapters.product.controller.GetProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductApiController {

    public CreateProductUseCase createUsecase;
    public GetProductUseCase getUseCase;

    public ProductApiController(CreateProductUseCase createUsecase, GetProductUseCase getUseCase) {
        this.createUsecase = createUsecase;
        this.getUseCase = getUseCase;
    }


    @GetMapping()
    public ResponseEntity<Collection<GetProductResponse>> getProduct() {
        Collection<GetProductOutput> outputs = getUseCase.getProducts();

        Collection<GetProductResponse> getProductsResponse = outputs.stream()
                .map(output ->
                        new GetProductResponse(output.id(), output.name(), output.unity(), output.createAt()))
                .collect(Collectors.toSet());


        return ResponseEntity.ok(getProductsResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable Long id) {
        GetProductOutput output = getUseCase.getProduct(id);

        return ResponseEntity.ok(new GetProductResponse(output.id(), output.name(), output.unity(), output.createAt()));
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request) throws ProductInvalidException {

        CreateProductOuput output = createUsecase.createProduct(new CreateProductInput(request.name(), request.unity()));

        return ResponseEntity.status(201).body(new CreateProductResponse(output.id(),output.name(), output.unity(), output.createAt()));
    }

}
