package org.foodbank.fooddonation.core.gateway.packet;

import org.foodbank.fooddonation.core.entity.packet.PacketProduct;

import java.util.Collection;

public interface CreatePacketProductGateway {
    Collection<PacketProduct> create(Collection<PacketProduct> input);
}
