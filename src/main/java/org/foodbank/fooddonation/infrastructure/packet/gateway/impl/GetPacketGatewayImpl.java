package org.foodbank.fooddonation.infrastructure.packet.gateway.impl;

import org.foodbank.fooddonation.core.entity.packet.Packet;
import org.foodbank.fooddonation.core.gateway.GetPacketGateway;
import org.foodbank.fooddonation.infrastructure.packet.repository.PacketRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class GetPacketGatewayImpl implements GetPacketGateway {

    private final PacketRepository repository;

    public GetPacketGatewayImpl(PacketRepository repository){
        this.repository = repository;
    }
    @Override
    public Collection<Packet> getPackets() {
        return repository.findAll().stream()
                .map(p ->
                        new Packet(p.getId(),
                                p.getVolunteer(),
                                p.getDonor(),
                                p.getType(),
                                p.getCreatedAt(),
                                new HashSet<>()))
                .collect(Collectors.toSet());
    }
}
