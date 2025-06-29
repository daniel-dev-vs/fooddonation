package org.foodbank.fooddonation.interfaceadapters.product.gateway;

import org.foodbank.fooddonation.enterprise.entity.product.Product;

import java.util.Collection;

public interface GetGatewayProduct {
    Product getProductById(Long id);
    Collection<Product> getProducts();

}
