package org.foodbank.fooddonation.core.gateway;

import org.foodbank.fooddonation.core.entity.packet.Packet;

import java.util.Collection;

public interface GetPacketGateway {
    Collection<Packet> getPackets();
}
