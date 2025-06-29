package org.foodbank.fooddonation.frameworksandrivers.packet.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/packets")
public class PacketApiController {

    @GetMapping
    public ResponseEntity<Object> getPacket(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPacket(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Object> getPacket(Object value){
        return ResponseEntity.ok().build();
    }
}
