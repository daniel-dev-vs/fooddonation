package org.foodbank.fooddonation.infrastructure.product.gateway.impl;

import org.foodbank.fooddonation.core.entity.product.Product;
import org.foodbank.fooddonation.infrastructure.product.persistence.ProductPersistence;
import org.foodbank.fooddonation.infrastructure.product.repository.ProductRepository;
import org.foodbank.fooddonation.core.gateway.product.GetProductGateway;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GetGatewayProductImpl implements GetProductGateway {

    private final ProductRepository productRepository;

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
