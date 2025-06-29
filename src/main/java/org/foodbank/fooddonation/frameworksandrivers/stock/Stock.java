package org.foodbank.fooddonation.frameworksandrivers.stock;

import jakarta.persistence.*;


@Entity
@Table(name ="STOCK")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProduct;
    private Long quantity;
}
