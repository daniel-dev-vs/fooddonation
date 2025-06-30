package org.foodbank.fooddonation.presentation.api.request.packet;

import java.time.LocalDateTime;
import java.util.Collection;

public record GetPacketResponse(Long id,
                                String volunteer,
                                String donor,
                                String type,
                                LocalDateTime createdAt,
                                Collection<GetPacketProductResponse> products
                                ) {
}
