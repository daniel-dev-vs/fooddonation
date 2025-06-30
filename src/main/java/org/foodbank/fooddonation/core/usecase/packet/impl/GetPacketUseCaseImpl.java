package org.foodbank.fooddonation.core.usecase.packet.impl;

import org.foodbank.fooddonation.core.entity.packet.Packet;
import org.foodbank.fooddonation.core.entity.packet.PacketProduct;
import org.foodbank.fooddonation.core.entity.product.Product;
import org.foodbank.fooddonation.core.gateway.packet.GetPacketGateway;
import org.foodbank.fooddonation.core.gateway.packet.GetPacketProductGateway;
import org.foodbank.fooddonation.core.usecase.packet.GetPacketUseCase;
import org.foodbank.fooddonation.core.usecase.packet.dto.GetPacketOuput;
import org.foodbank.fooddonation.core.usecase.packet.dto.GetPacketProductOuput;


import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetPacketUseCaseImpl implements GetPacketUseCase {

    private final GetPacketProductGateway getPacketProductGateway;
    private final GetPacketGateway getPacketGateway;

    public GetPacketUseCaseImpl(GetPacketProductGateway getPacketProductGateway, GetPacketGateway getPacketGateway) {
        this.getPacketProductGateway = getPacketProductGateway;
        this.getPacketGateway = getPacketGateway;
    }

    @Override
    public Collection<GetPacketOuput> getPackets() {
        Collection<Packet> packets = getPacketGateway.getPackets();

        return packets.stream()
                .map(p ->
                        new GetPacketOuput(
                                p.getId(),
                                p.getVolunteer(),
                                p.getDonor(),
                                p.getType(),
                                p.getCreateAt(),
                                getPacketProductOutput(p.getProducts(),p.getPacketProducts())))
                .collect(Collectors.toSet());
    }

    private Collection<GetPacketProductOuput> getPacketProductOutput(Collection<Product> products,
                                                                     Collection<PacketProduct> packetProducts) {

        Map<Long, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

        return packetProducts.stream()
                .map(packetProduct -> {
                    Product product = productMap.get(packetProduct.productId());
                    if (product == null) {
                        throw new IllegalArgumentException("Product not found for packetProduct ID: " + packetProduct.productId());
                    }
                    return new GetPacketProductOuput(product.getId(), product.getName(), product.getUnity(), packetProduct.quantity());
                })
                .collect(Collectors.toSet());


    }
}
