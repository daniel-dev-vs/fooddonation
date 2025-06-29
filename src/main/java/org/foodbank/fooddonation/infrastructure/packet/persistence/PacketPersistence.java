package org.foodbank.fooddonation.infrastructure.packet.persistence;

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
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "packetPersistence", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PacketProductPersistence> packetProductPersistences = new HashSet<>();


    public PacketPersistence(){}
    ;
    public PacketPersistence(Long id) {
        this.id = id;
    }

    public PacketPersistence(String volunteer, String donor, String type, LocalDateTime createAt) {
        this.volunteer = volunteer;
        this.donor = donor;
        this.type = type;
        this.createdAt = createAt;
    }

    public PacketPersistence(Long id, String volunteer, String donor, String type, LocalDateTime createAt, Set<PacketProductPersistence> packetProducts) {
        this.id = id;
        this.volunteer = volunteer;
        this.donor = donor;
        this.type = type;
        this.createdAt = createAt;
        this.packetProductPersistences = packetProducts;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<PacketProductPersistence> getPacketProductPersistences() {
        return packetProductPersistences;
    }

    public void getPacketProductPersistences(Set<PacketProductPersistence> packetProductPersistences) {
        this.packetProductPersistences = packetProductPersistences;
    }
}
