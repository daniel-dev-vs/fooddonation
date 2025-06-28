package org.foodbank.fooddonation.interfaceadapters.gateway.product;

import org.foodbank.fooddonation.enterprise.entity.product.Product;

public interface CreateGatewayProduct {
    Product save(Product product);
}
