package org.foodbank.fooddonation.infrastructure.persistence;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long unity;
    private String typeUnity;
    private LocalDateTime create_at;

    @ManyToOne
    @JoinColumn(name = "packet_id", nullable = false )
    private Packet packet;

}
