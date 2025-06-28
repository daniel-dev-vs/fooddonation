package org.foodbank.fooddonation.frameworksandrivers.repository;

import org.foodbank.fooddonation.frameworksandrivers.persistence.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
