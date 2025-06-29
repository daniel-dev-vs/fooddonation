package org.foodbank.fooddonation.infrastructure.product.repository;

import org.foodbank.fooddonation.infrastructure.product.persistence.ProductPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductPersistence, Long> {
}
