package org.foodbank.fooddonation.core.usecase.product;

import org.foodbank.fooddonation.core.usecase.product.dto.CreateProductInput;
import org.foodbank.fooddonation.core.usecase.product.dto.CreateProductOuput;
import org.foodbank.fooddonation.core.entity.product.ProductInvalidException;

public interface CreateProductUseCase {

    CreateProductOuput createProduct(CreateProductInput input) throws ProductInvalidException;
}
