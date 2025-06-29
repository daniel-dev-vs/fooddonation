package org.foodbank.fooddonation.enterprise.entity.packet;

import org.foodbank.fooddonation.enterprise.entity.product.Product;

import java.time.LocalDateTime;
import java.util.Set;

public class Packet {
    private Long id;
    private Long donor;
    private String volunteer;
    private String type;
    private LocalDateTime createAt;
    private Set<Product> products;

}
