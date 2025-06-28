package org.foodbank.fooddonation.interfaceadapters.controller;

import org.foodbank.fooddonation.application.usecase.product.dto.CreateProductInput;
import org.foodbank.fooddonation.application.usecase.product.dto.CreateProductOuput;
import org.foodbank.fooddonation.enterprise.entity.product.ProductInvalidException;

public interface CreateProductUseCase {

    CreateProductOuput createProduct(CreateProductInput input) throws ProductInvalidException;
}
