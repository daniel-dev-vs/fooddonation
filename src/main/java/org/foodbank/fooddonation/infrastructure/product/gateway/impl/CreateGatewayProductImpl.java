package org.foodbank.fooddonation.infrastructure.product.gateway.impl;

import org.foodbank.fooddonation.core.entity.product.Product;
import org.foodbank.fooddonation.infrastructure.product.persistence.ProductPersistence;
import org.foodbank.fooddonation.infrastructure.product.repository.ProductRepository;
import org.foodbank.fooddonation.core.gateway.product.CreateProductGateway;
import org.springframework.stereotype.Component;

@Component
public class CreateGatewayProductImpl implements CreateProductGateway {

    private ProductRepository productRepository;

    public CreateGatewayProductImpl(ProductRepository repository){
        this.productRepository = repository;
    }

    @Override
    public Product save(Product product) {
        ProductPersistence persistence = new ProductPersistence(product.getName(),product.getUnity(),product.getCreatedAt());

        ProductPersistence newProductPersistence = productRepository.save(persistence);

        return new Product(newProductPersistence.getId(),
                newProductPersistence.getName(),
                newProductPersistence.getUnity(),
                newProductPersistence.getCreatedAt());
    }
}
