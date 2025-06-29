package org.foodbank.fooddonation.interfaceadapters.product.gateway.impl;

import org.foodbank.fooddonation.enterprise.entity.product.Product;
import org.foodbank.fooddonation.frameworksandrivers.product.persistence.ProductPersistence;
import org.foodbank.fooddonation.frameworksandrivers.product.repository.ProductRepository;
import org.foodbank.fooddonation.interfaceadapters.product.gateway.CreateGatewayProduct;

public class CreateGatewayProductImpl implements CreateGatewayProduct {

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
