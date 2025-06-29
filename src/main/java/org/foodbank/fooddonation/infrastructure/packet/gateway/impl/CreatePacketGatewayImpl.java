package org.foodbank.fooddonation.infrastructure.packet.gateway.impl;

import org.foodbank.fooddonation.core.entity.packet.Packet;
import org.foodbank.fooddonation.core.gateway.packet.CreatePacketGateway;
import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketPersistence;
import org.foodbank.fooddonation.infrastructure.packet.repository.PacketRepository;
import org.springframework.stereotype.Component;

@Component
public class CreatePacketGatewayImpl implements CreatePacketGateway {

    private final PacketRepository repository;

    public CreatePacketGatewayImpl(PacketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Packet create(Packet packet) {

        PacketPersistence saved = repository.save(new PacketPersistence(
                packet.getVolunteer(),
                packet.getDonor(),
                packet.getType(),
                packet.getCreateAt()));

        return new Packet(
                saved.getId(),
                saved.getDonor(),
                saved.getVolunteer(),
                saved.getType(),
                saved.getCreatedAt());


    }
}
