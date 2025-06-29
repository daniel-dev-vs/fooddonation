package org.foodbank.fooddonation.core.usecase.packet.dto;

import java.time.LocalDateTime;

public record GetPacketOuput(Long id, String volunteer, String donor, String type, LocalDateTime createdAt) {
}
