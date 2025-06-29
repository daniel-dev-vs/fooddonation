package org.foodbank.fooddonation.interfaceadapters.product.gateway;

import org.foodbank.fooddonation.enterprise.entity.product.Product;

public interface CreateGatewayProduct {
    Product save(Product product);
}
