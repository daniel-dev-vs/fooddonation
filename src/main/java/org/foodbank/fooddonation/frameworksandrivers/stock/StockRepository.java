package org.foodbank.fooddonation.frameworksandrivers.stock;

import org.foodbank.fooddonation.frameworksandrivers.packet.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
