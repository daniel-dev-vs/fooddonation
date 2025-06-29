package org.foodbank.fooddonation.core.gateway.product;

import org.foodbank.fooddonation.core.entity.product.Product;

public interface CreateProductGateway {
    Product save(Product product);
}
