package org.foodbank.fooddonation.core.usecase.packet.dto;

import java.util.Collection;

public record CreatePacketOuput(Long id,
                                String donor,
                                String volunteer,
                                String type,
                                Collection<CreatePacketProductOutput> productList) {
}
