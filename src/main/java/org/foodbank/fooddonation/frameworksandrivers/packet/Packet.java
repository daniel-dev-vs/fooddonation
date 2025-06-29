package org.foodbank.fooddonation.frameworksandrivers.packet;

import jakarta.persistence.*;
import org.foodbank.fooddonation.frameworksandrivers.product.persistence.ProductPersistence;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="PACKET")
public class Packet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String volunteer;
    private String donor;
    private String type;
    private LocalDateTime create_at;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "PACKET_PRODUCT",
            joinColumns = {@JoinColumn(name = "packet_id") },
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private Set<ProductPersistence> products = new HashSet<>();


    public Packet(Long id, String volunteer, String donor, String type, LocalDateTime create_at) {
        this.id = id;
        this.volunteer = volunteer;
        this.donor = donor;
        this.type = type;
        this.create_at = create_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public Set<ProductPersistence> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductPersistence> products) {
        this.products = products;
    }
}
