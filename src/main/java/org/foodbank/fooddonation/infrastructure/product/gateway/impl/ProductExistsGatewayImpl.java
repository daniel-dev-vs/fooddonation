package org.foodbank.fooddonation.infrastructure.product.gateway.impl;

import org.foodbank.fooddonation.core.gateway.product.ProductExistsGateway;
import org.foodbank.fooddonation.infrastructure.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductExistsGatewayImpl implements ProductExistsGateway {
    private final ProductRepository repository;

    public ProductExistsGatewayImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean checkById(Long id) {
        return repository.existsById(id);
    }
}
