package org.foodbank.fooddonation.core.entity.packet;

import org.foodbank.fooddonation.core.entity.product.Product;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Packet {
    private Long id;
    private String donor;
    private String volunteer;
    private String type;
    private LocalDateTime createAt;
    private Set<Product> products;

    public Packet(Long id, String donor, String volunteer, String type, LocalDateTime createAt) {
        this.id = id;
        this.donor = donor;
        this.volunteer = volunteer;
        this.type = type;
        this.createAt = createAt;
    }

    public Packet(Long id, String donor, String volunteer, String type, LocalDateTime createAt, Set<Product> products) {
        this.id = id;
        this.donor = donor;
        this.volunteer = volunteer;
        this.type = type;
        this.createAt = createAt;
        this.products = products;
    }

    public Packet(String donor, String volunteer, String type, LocalDateTime createAt) {
        this.donor = donor;
        this.volunteer = volunteer;
        this.type = type;
        this.createAt = createAt;
    }

    public void validate() throws PacketInvalidException {
        validateFieldString(this.donor);
        validateFieldString(this.volunteer);
        validateFieldString(this.type);
        validateTypePacket();
    }

    public void validateFieldString(String field) throws PacketInvalidException {
        if(field == null || field.isBlank())
            throw new PacketInvalidException("The packet is invalid, the field donor,volunteer and type should be fill it.");
    }

    public void validateTypePacket() throws PacketInvalidException {
        if(!Objects.equals(this.type, "IN") && !Objects.equals(this.type, "OUT")){
            throw new PacketInvalidException("The field type should be fill out with values 'IN' or 'OUT'");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
