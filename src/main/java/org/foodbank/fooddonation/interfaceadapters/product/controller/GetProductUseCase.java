package org.foodbank.fooddonation.interfaceadapters.product.controller;

import org.foodbank.fooddonation.application.usecase.product.dto.GetProductOutput;

import java.util.Collection;

public interface GetProductUseCase {
    GetProductOutput getProduct(Long id);

    Collection<GetProductOutput> getProducts();
}
