package org.foodbank.fooddonation.core.usecase.packet;

import org.foodbank.fooddonation.core.entity.packet.PacketInvalidException;
import org.foodbank.fooddonation.core.usecase.packet.dto.CreatePacketInput;
import org.foodbank.fooddonation.core.usecase.packet.dto.CreatePacketOuput;

public interface CreatePacketUseCase {
    CreatePacketOuput create(CreatePacketInput input) throws PacketInvalidException;
}
