package org.foodbank.fooddonation.frameworksandrivers.product.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.foodbank.fooddonation.frameworksandrivers.packet.persistence.Packet;


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

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private Set<Packet> packets;


    public ProductPersistence() {
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

    public Set<Packet> getPacket() {
        return packets;
    }

    public void setPacket(Set<Packet> packets) {
        this.packets = packets;
    }
}
