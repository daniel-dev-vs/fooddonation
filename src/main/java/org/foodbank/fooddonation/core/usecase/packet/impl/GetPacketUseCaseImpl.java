package org.foodbank.fooddonation.core.usecase.packet.impl;

import org.foodbank.fooddonation.core.entity.packet.Packet;
import org.foodbank.fooddonation.core.gateway.packet.GetPacketGateway;
import org.foodbank.fooddonation.core.gateway.packet.GetPacketProductGateway;
import org.foodbank.fooddonation.core.usecase.packet.GetPacketUseCase;
import org.foodbank.fooddonation.core.usecase.packet.dto.GetPacketOuput;


import java.util.Collection;
import java.util.stream.Collectors;

public class GetPacketUseCaseImpl implements GetPacketUseCase {

    private final GetPacketProductGateway getPacketProductGateway;
    private final GetPacketGateway getPacketGateway;

    public GetPacketUseCaseImpl(GetPacketProductGateway getPacketProductGateway, GetPacketGateway getPacketGateway) {
        this.getPacketProductGateway = getPacketProductGateway;
        this.getPacketGateway = getPacketGateway;
    }

    @Override
    public Collection<GetPacketOuput> getPackets() {
        Collection<Packet> packets = getPacketGateway.getPackets();

        return packets.stream()
                .map(p -> new GetPacketOuput(p.getId(), p.getVolunteer(), p.getDonor(), p.getType(), p.getCreateAt()))
                .collect(Collectors.toSet());
    }
}
