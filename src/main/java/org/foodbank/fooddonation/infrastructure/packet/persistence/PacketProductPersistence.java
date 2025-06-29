package org.foodbank.fooddonation.infrastructure.packet.persistence;

import jakarta.persistence.*;
import org.foodbank.fooddonation.infrastructure.product.persistence.ProductPersistence;

import java.util.Objects;

@Entity
@Table(name = "PACKET_PRODUCT")
public class PacketProductPersistence {
    @EmbeddedId
    private PacketProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("packetId")
    @JoinColumn(name = "packet_id")
    private PacketPersistence packetPersistence;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductPersistence productPersistence;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    public PacketProductPersistence() {
        this.id = new PacketProductId();
    }


    public PacketProductPersistence(PacketPersistence packet, ProductPersistence product, Long quantity) {
        this.packetPersistence = packet;
        this.productPersistence = product;
        this.quantity = quantity;
        this.id = new PacketProductId(packet.getId(), product.getId());
    }

    public PacketProductId getId() {
        return id;
    }

    public void setId(PacketProductId id) {
        this.id = id;
    }

    public PacketPersistence getPacketPersistence() {
        return packetPersistence;
    }

    public void setPacketPersistence(PacketPersistence packetPersistence) {
        this.packetPersistence = packetPersistence;
        if (packetPersistence != null) {
            this.id.setPacketId(packetPersistence.getId());
        }
    }

    public ProductPersistence getProductPersistence() {
        return productPersistence;
    }

    public void setProductPersistence(ProductPersistence productPersistence) {
        this.productPersistence = productPersistence;
        if (productPersistence != null) {
            this.id.setProductId(productPersistence.getId());
        }
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacketProductPersistence that = (PacketProductPersistence) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
