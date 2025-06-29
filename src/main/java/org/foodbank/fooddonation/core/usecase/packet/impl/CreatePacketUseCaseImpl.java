package org.foodbank.fooddonation.core.usecase.packet.impl;

import org.foodbank.fooddonation.core.entity.packet.Packet;
import org.foodbank.fooddonation.core.entity.packet.PacketInvalidException;
import org.foodbank.fooddonation.core.entity.packet.PacketProduct;
import org.foodbank.fooddonation.core.gateway.GetPacketGateway;
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
    private final GetPacketGateway getPacketGateway;

    public CreatePacketUseCaseImpl(ProductExistsGateway productGateway,
                                   CreatePacketGateway createPacketGateway,
                                   CreatePacketProductGateway createPacketProductGateway,
                                   GetPacketGateway getPacketGateway) {

        this.productGateway = productGateway;
        this.createPacketGateway = createPacketGateway;
        this.createPacketProductGateway = createPacketProductGateway;
        this.getPacketGateway = getPacketGateway;
    }




    public Collection<GetPacketOuput> getPackets(){
        Collection<Packet> packets = getPacketGateway.getPackets();
        return packets.stream().map(p -> new GetPacketOuput(p.getId(),p.getVolunteer(), p.getDonor(),p.getType(),p.getCreateAt()))
                .collect(Collectors.toSet());
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
                packetProductList.stream().map(p -> new CreatePacketProductOutput(p.productId(), "teste", p.quantity()))
                        .collect(Collectors.toSet())
        );


    }

    private Long getQuantity(Collection<PacketProduct> packetProductList, Long productId) {

        return packetProductList.stream().filter(pp -> Objects.equals(pp.productId(), productId)).findFirst().get().quantity();
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
