package org.foodbank.fooddonation.presentation.api.request.packet;

import java.util.Collection;

public record CreatePacketRequest(String volunteer,
                                  String donor,
                                  String type,
                                  Collection<CreatePacketProductsRequest> products) {
}
