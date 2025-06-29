package org.foodbank.fooddonation.infrastructure.packet.controller;

import org.foodbank.fooddonation.core.entity.packet.PacketInvalidException;
import org.foodbank.fooddonation.core.gateway.packet.GetPacketGateway;
import org.foodbank.fooddonation.core.gateway.packet.CreatePacketGateway;
import org.foodbank.fooddonation.core.gateway.packet.CreatePacketProductGateway;
import org.foodbank.fooddonation.core.gateway.product.ProductExistsGateway;
import org.foodbank.fooddonation.core.usecase.packet.CreatePacketUseCase;
import org.foodbank.fooddonation.core.usecase.packet.GetPacketUseCase;
import org.foodbank.fooddonation.core.usecase.packet.dto.CreatePacketInput;
import org.foodbank.fooddonation.core.usecase.packet.dto.CreatePacketOuput;
import org.foodbank.fooddonation.core.usecase.packet.dto.CreatePacketProductInput;
import org.foodbank.fooddonation.core.usecase.packet.impl.CreatePacketUseCaseImpl;
import org.foodbank.fooddonation.core.usecase.packet.impl.GetPacketUseCaseImpl;
import org.foodbank.fooddonation.presentation.api.request.packet.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class PacketControllerImpl implements PacketController {


    private final GetPacketGateway getPacketGateway;
    private final CreatePacketGateway createPacketGateway;
    private final ProductExistsGateway productExistsGateway;
    private final CreatePacketUseCase createPacketUseCase;
    private final CreatePacketProductGateway createPacketProductGateway;
    private final GetPacketUseCase getPacketUseCase;

    public PacketControllerImpl(GetPacketGateway getPacketGateway,
                                CreatePacketGateway createPacketGateway,
                                ProductExistsGateway productExistsGateway,
                                CreatePacketProductGateway createPacketProductGateway
                                ) {
        this.getPacketGateway = getPacketGateway;
        this.createPacketGateway = createPacketGateway;
        this.productExistsGateway = productExistsGateway;
        this.createPacketProductGateway = createPacketProductGateway;

        this.createPacketUseCase = new CreatePacketUseCaseImpl(
                this.productExistsGateway,
                this.createPacketGateway,
                this.createPacketProductGateway,
                this.getPacketGateway);

        this.getPacketUseCase = new GetPacketUseCaseImpl(null, getPacketGateway);
    }

    @Override
    public Collection<GetPacketResponse> getPackets() {

        this.getPacketUseCase.getPackets();


        return getPacketGateway.getPackets()
                .stream()
                .map(p ->
                        new GetPacketResponse(p.getId(), p.getDonor()))
                .collect(Collectors.toSet());
    }

    @Override
    public CreatePacketResponse createPacket(CreatePacketRequest request) throws PacketInvalidException {

        CreatePacketOuput packetCreated = this.createPacketUseCase.create(new CreatePacketInput(
                request.donor(),
                request.volunteer(),
                request.type(),
                request.products()
                        .stream()
                        .map(r -> new CreatePacketProductInput(r.id(),r.quantity()))
                        .collect(Collectors.toSet())
                )
        );


        return new CreatePacketResponse(
                packetCreated.id(),
                packetCreated.donor(),
                packetCreated.volunteer(),
                packetCreated.productList()
                        .stream()
                        .map(p -> new CreatePacketProductsResponse(p.id(),p.quantity()))
                        .collect(Collectors.toSet()));

    }


}
