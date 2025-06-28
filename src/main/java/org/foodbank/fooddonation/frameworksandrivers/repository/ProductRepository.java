package org.foodbank.fooddonation.frameworksandrivers.repository;

import org.foodbank.fooddonation.frameworksandrivers.persistence.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
