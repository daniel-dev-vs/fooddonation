package org.foodbank.fooddonation.core.gateway.packet;

import org.foodbank.fooddonation.core.entity.packet.Packet;

public interface CreatePacketGateway {
    Packet create(Packet packet);
}
