package org.foodbank.fooddonation.frameworksandrivers.product.repository;

import org.foodbank.fooddonation.frameworksandrivers.product.persistence.ProductPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductPersistence, Long> {
}
