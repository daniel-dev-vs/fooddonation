package org.foodbank.fooddonation.core.usecase.packet.dto;

import java.time.LocalDateTime;
import java.util.Collection;

public record GetPacketOuput(Long id,
                             String volunteer,
                             String donor,
                             String type,
                             LocalDateTime createdAt,
                             Collection<GetPacketProductOuput> products) {
}
