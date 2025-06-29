package org.foodbank.fooddonation.presentation.api.request.packet;

import java.util.Collection;

public record CreatePacketResponse(Long id, String donor, String volunteer, Collection<CreatePacketProductsResponse> products) {
}
