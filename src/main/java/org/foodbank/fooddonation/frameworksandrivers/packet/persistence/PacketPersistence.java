package org.foodbank.fooddonation.frameworksandrivers.packet.persistence;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="PACKET")
public class PacketPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String volunteer;
    private String donor;
    private String type;
    private LocalDateTime create_at;

    @OneToMany(mappedBy = "packetPersistence", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PacketProductPersistence> packetProductPersistences = new HashSet<>();


    public PacketPersistence(Long id, String volunteer, String donor, String type, LocalDateTime create_at) {
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

    public Set<PacketProductPersistence> getProducts() {
        return packetProductPersistences;
    }

    public void setProducts(Set<PacketProductPersistence> products) {
        this.packetProductPersistences = products;
    }
}
