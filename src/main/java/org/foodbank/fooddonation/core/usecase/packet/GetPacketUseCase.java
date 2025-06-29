package org.foodbank.fooddonation.core.usecase.packet;



import org.foodbank.fooddonation.core.usecase.packet.dto.GetPacketOuput;

import java.util.Collection;


public interface GetPacketUseCase {
    Collection<GetPacketOuput> getPackets();
}
