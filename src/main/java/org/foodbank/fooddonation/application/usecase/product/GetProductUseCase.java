package org.foodbank.fooddonation.core.usecase.product;

import org.foodbank.fooddonation.core.entity.product.ProductNotFoundException;
import org.foodbank.fooddonation.core.usecase.product.dto.GetProductOutput;

import java.util.Collection;

public interface GetProductUseCase {
    GetProductOutput getProductById(Long id) throws IllegalArgumentException, ProductNotFoundException;

    Collection<GetProductOutput> getProducts();
}
