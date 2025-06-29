package org.foodbank.fooddonation.core.gateway.product;

import org.foodbank.fooddonation.core.entity.product.Product;

import java.util.Collection;

public interface GetProductGateway {
    Product getProductById(Long id);
    Collection<Product> getProducts();

}
