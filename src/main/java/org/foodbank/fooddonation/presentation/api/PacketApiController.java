package org.foodbank.fooddonation.presentation.api;

import org.foodbank.fooddonation.core.entity.packet.PacketInvalidException;
import org.foodbank.fooddonation.infrastructure.packet.controller.PacketController;
import org.foodbank.fooddonation.presentation.api.request.packet.CreatePacketRequest;
import org.foodbank.fooddonation.presentation.api.request.packet.CreatePacketResponse;
import org.foodbank.fooddonation.presentation.api.request.packet.GetPacketResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/packets")
public class PacketApiController {

    private final PacketController packetController;

    public PacketApiController(PacketController packet) {
        this.packetController = packet;
    }

    @GetMapping
    public ResponseEntity<Collection<GetPacketResponse>> getPacketController(){
        return ResponseEntity.ok(packetController.getPackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPacket(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<CreatePacketResponse> getPacket(@RequestBody CreatePacketRequest request) throws PacketInvalidException {
        return ResponseEntity.ok(packetController.createPacket(request));
    }
}
