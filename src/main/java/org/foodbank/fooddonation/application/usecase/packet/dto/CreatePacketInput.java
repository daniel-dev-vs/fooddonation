package org.foodbank.fooddonation.core.usecase.packet.dto;

import java.util.Collection;

public record CreatePacketInput(String donor,
                                String volunteer,
                                String type,
                                Collection<CreatePacketProductInput> productList
) {}
