package org.foodbank.fooddonation.core.usecase.packet.impl;

import org.foodbank.fooddonation.core.entity.packet.Packet;
import org.foodbank.fooddonation.core.entity.packet.PacketInvalidException;
import org.foodbank.fooddonation.core.entity.packet.PacketProduct;
import org.foodbank.fooddonation.core.gateway.packet.GetPacketGateway;
import org.foodbank.fooddonation.core.gateway.packet.CreatePacketGateway;
import org.foodbank.fooddonation.core.gateway.packet.CreatePacketProductGateway;

import org.foodbank.fooddonation.core.gateway.product.ProductExistsGateway;
import org.foodbank.fooddonation.core.usecase.packet.CreatePacketUseCase;
import org.foodbank.fooddonation.core.usecase.packet.dto.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class CreatePacketUseCaseImpl implements CreatePacketUseCase {

    private final ProductExistsGateway productGateway;
    private final CreatePacketGateway createPacketGateway;
    private final CreatePacketProductGateway createPacketProductGateway;

    public CreatePacketUseCaseImpl(ProductExistsGateway productGateway,
                                   CreatePacketGateway createPacketGateway,
                                   CreatePacketProductGateway createPacketProductGateway
                                   ) {

        this.productGateway = productGateway;
        this.createPacketGateway = createPacketGateway;
        this.createPacketProductGateway = createPacketProductGateway;
    }




    @Override
    public CreatePacketOuput create(CreatePacketInput input) throws PacketInvalidException {
        validateProductExists(input.productList());

        Packet packetCreated = createPacketGateway.create(new Packet(input.donor(), input.volunteer(), input.type(), LocalDateTime.now()));
        var packetProductList = createPacketsProducts(input, packetCreated);

        return new CreatePacketOuput(
                packetCreated.getId(),
                packetCreated.getDonor(),
                packetCreated.getVolunteer(),
                packetCreated.getType(),
                packetProductList.stream().map(p -> new CreatePacketProductOutput(p.productId(),  p.quantity()))
                        .collect(Collectors.toSet())
        );


    }

    private void validateProductExists(Collection<CreatePacketProductInput> productList) throws PacketInvalidException {
        for (var product : productList) {
            if (!this.productGateway.checkById(product.productId())) {
                throw new PacketInvalidException(String.format("The product id:{0} doesn't exist", product.productId()));
            }
        }
    }

    private Collection<PacketProduct> createPacketsProducts(CreatePacketInput packetInput, Packet packetCreated) {

        Collection<PacketProduct> input = packetInput.productList()
                .stream()
                .map(p ->
                        new PacketProduct(packetCreated.getId(),
                                p.productId(),
                                p.quantity()))
                .collect(Collectors.toSet());


        return this.createPacketProductGateway.create(input);
    }
}
