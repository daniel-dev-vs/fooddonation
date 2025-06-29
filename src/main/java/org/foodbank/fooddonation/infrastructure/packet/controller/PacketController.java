package org.foodbank.fooddonation.infrastructure.packet.controller;

import org.foodbank.fooddonation.core.entity.packet.PacketInvalidException;
import org.foodbank.fooddonation.presentation.api.request.packet.CreatePacketRequest;
import org.foodbank.fooddonation.presentation.api.request.packet.CreatePacketResponse;
import org.foodbank.fooddonation.presentation.api.request.packet.GetPacketResponse;

import java.util.Collection;

public interface PacketController {
    Collection<GetPacketResponse> getPackets();
    CreatePacketResponse createPacket(CreatePacketRequest request) throws PacketInvalidException;
}
