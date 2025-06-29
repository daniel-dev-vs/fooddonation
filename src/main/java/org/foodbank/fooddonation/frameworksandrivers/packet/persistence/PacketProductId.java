package org.foodbank.fooddonation.frameworksandrivers.packet.persistence;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PacketProductId implements Serializable {
    private Long packetId;
    private Long productId;

    // Construtor padrão
    public PacketProductId() {
    }

    // Construtor com campos
    public PacketProductId(Long packetId, Long productId) {
        this.packetId = packetId;
        this.productId = productId;
    }

    // Getters e Setters
    public Long getPacketId() {
        return packetId;
    }

    public void setPacketId(Long packetId) {
        this.packetId = packetId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacketProductId that = (PacketProductId) o;
        return Objects.equals(packetId, that.packetId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packetId, productId);
    }
}
