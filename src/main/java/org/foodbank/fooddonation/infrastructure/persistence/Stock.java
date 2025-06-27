package org.foodbank.fooddonation.infrastructure.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("STOCK")
public class Stock {

    @Id
    private Long id;
    private Long idProduct;
    private Long quantity;
}
