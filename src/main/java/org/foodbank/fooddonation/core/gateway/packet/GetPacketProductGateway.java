package org.foodbank.fooddonation.core.gateway.packet;


import org.foodbank.fooddonation.core.entity.packet.PacketProduct;

public interface GetPacketProductGateway {
    PacketProduct getPacketProductById(Long id);
}
