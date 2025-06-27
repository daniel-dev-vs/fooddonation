package org.foodbank.fooddonation.infrastructure.repositories;

import org.foodbank.fooddonation.infrastructure.persistence.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
