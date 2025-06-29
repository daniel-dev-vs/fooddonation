package org.foodbank.fooddonation.infrastructure.product.persistence;


import jakarta.persistence.*;
import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketProductPersistence;


import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class ProductPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String unity;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "productPersistence", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PacketProductPersistence> packetProducts;


    public ProductPersistence() {
    }

    public ProductPersistence(Long id) {
        this.id = id;
    }

    public ProductPersistence(String name, String unity, LocalDateTime createdAt) {
        this.name = name;
        this.unity = unity;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<PacketProductPersistence> getPacketProducts() {
        return packetProducts;
    }

    public void setPacketProducts(Set<PacketProductPersistence> packets) {
        this.packetProducts = packets;
    }
}
