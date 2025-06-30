package org.foodbank.fooddonation.infrastructure.packet.gateway.impl;

import org.foodbank.fooddonation.core.entity.packet.Packet;
import org.foodbank.fooddonation.core.entity.packet.PacketProduct;
import org.foodbank.fooddonation.core.entity.product.Product;
import org.foodbank.fooddonation.core.gateway.packet.GetPacketGateway;
import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketProductPersistence;
import org.foodbank.fooddonation.infrastructure.packet.repository.PacketRepository;


import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class GetPacketGatewayImpl implements GetPacketGateway {

    private final PacketRepository repository;

    public GetPacketGatewayImpl(PacketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Packet> getPackets() {

        return repository.findAllWithProducts().stream()
                .map(p ->
                        new Packet(p.getId(),
                                p.getVolunteer(),
                                p.getDonor(),
                                p.getType(),
                                p.getCreatedAt(),
                                getProducts(p.getPacketProductPersistences()),
                                getPacketProducts(p.getPacketProductPersistences())))
                .collect(Collectors.toSet());


    }


    private Collection<Product> getProducts(Collection<PacketProductPersistence> packetProductsPersistence) {
        return  packetProductsPersistence
                .stream()
                .map(pp ->
                        new Product(
                                pp.getProductPersistence().getId(),
                                pp.getProductPersistence().getName(),
                                pp.getProductPersistence().getUnity(),
                                pp.getProductPersistence().getCreatedAt()
                        )
                )
                .collect(Collectors.toSet());

    }

    private Collection<PacketProduct> getPacketProducts(Collection<PacketProductPersistence> packetProductsPersistence) {
        return  packetProductsPersistence
                .stream()
                .map(pp -> new PacketProduct(pp.getId().getPacketId(),pp.getId().getProductId(), pp.getQuantity()))
                .collect(Collectors.toSet());

    }



}
