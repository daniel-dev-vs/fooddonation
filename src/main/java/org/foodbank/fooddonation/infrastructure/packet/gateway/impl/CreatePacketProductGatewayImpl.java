package org.foodbank.fooddonation.infrastructure.packet.gateway.impl;


import org.foodbank.fooddonation.core.entity.packet.PacketProduct;
import org.foodbank.fooddonation.core.gateway.packet.CreatePacketProductGateway;
import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketPersistence;
import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketProductPersistence;
import org.foodbank.fooddonation.infrastructure.packet.repository.PacketProductRepository;
import org.foodbank.fooddonation.infrastructure.product.persistence.ProductPersistence;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreatePacketProductGatewayImpl implements CreatePacketProductGateway {

    private final PacketProductRepository repository;

    public CreatePacketProductGatewayImpl(PacketProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<PacketProduct> create(Collection<PacketProduct> input) {

        Collection<PacketProductPersistence> packetsProducts = input.stream().map(p -> new PacketProductPersistence(
                new PacketPersistence(p.packetId()),
                new ProductPersistence(p.productId()),
                p.quantity()
        )).collect(Collectors.toSet());


        Collection<PacketProductPersistence> saved = repository.saveAll(packetsProducts);

        return saved
                .stream()
                .map(p -> new PacketProduct(
                        p.getPacketPersistence().getId(),
                        p.getProductPersistence().getId(),
                        p.getQuantity())).
                collect(Collectors.toSet());
    }


}
