package org.foodbank.fooddonation.infrastructure.persistence;


import jakarta.persistence.*;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Entity
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
