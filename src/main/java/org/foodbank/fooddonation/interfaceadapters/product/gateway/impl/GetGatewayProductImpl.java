package org.foodbank.fooddonation.interfaceadapters.product.gateway.impl;

import org.foodbank.fooddonation.enterprise.entity.product.Product;
import org.foodbank.fooddonation.frameworksandrivers.product.persistence.ProductPersistence;
import org.foodbank.fooddonation.frameworksandrivers.product.repository.ProductRepository;
import org.foodbank.fooddonation.interfaceadapters.product.gateway.GetGatewayProduct;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class GetGatewayProductImpl implements GetGatewayProduct {

    private ProductRepository productRepository;

    public GetGatewayProductImpl(ProductRepository repository) {
        this.productRepository = repository;
    }


    @Override
    public Product getProductById(Long id) {
        Optional<ProductPersistence> productPersistence = productRepository.findById(id);
        Product product = null;
        if (productPersistence.isPresent() && productPersistence.get().getId() != null) {

            product = new Product(productPersistence.get().getId(),
                    productPersistence.get().getName(),
                    productPersistence.get().getUnity(),
                    productPersistence.get().getCreatedAt());
        }

        return product;
    }

    @Override
    public Collection<Product> getProducts() {
        Collection<ProductPersistence> productPersistences = this.productRepository.findAll();

        return productPersistences.stream()
                .map(pp -> new Product(
                        pp.getId(),
                        pp.getName(),
                        pp.getUnity(),
                        pp.getCreatedAt()))
                .collect(Collectors.toSet());
    }
}
