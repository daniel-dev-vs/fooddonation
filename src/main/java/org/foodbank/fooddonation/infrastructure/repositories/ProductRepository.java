package org.foodbank.fooddonation.infrastructure.repositories;

import org.foodbank.fooddonation.infrastructure.persistence.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
