package org.foodbank.fooddonation.presentation.api.request.packet;

import java.time.LocalDateTime;
import java.util.Collection;

public record GetPacketProductResponse(Long id, String name, String unity, Long quantity) {
}
