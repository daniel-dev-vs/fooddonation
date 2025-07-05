package org.foodbank.fooddonation.core.usecase.packet.dto;

import java.time.LocalDateTime;
import java.util.Collection;

public record GetPacketProductOuput(Long productId, String name, String unity, Long quantity) {
}
