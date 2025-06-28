package org.foodbank.fooddonation.frameworksandrivers.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long unity;
    private String typeUnity;
    private LocalDateTime create_at;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private Set<Packet> packets;

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

    public Long getUnity() {
        return unity;
    }

    public void setUnity(Long unity) {
        this.unity = unity;
    }

    public String getTypeUnity() {
        return typeUnity;
    }

    public void setTypeUnity(String typeUnity) {
        this.typeUnity = typeUnity;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public Set<Packet> getPacket() {
        return packets;
    }

    public void setPacket(Set<Packet> packets) {
        this.packets = packets;
    }
}
