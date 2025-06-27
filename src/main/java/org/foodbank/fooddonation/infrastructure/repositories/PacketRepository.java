package org.foodbank.fooddonation.infrastructure.repositories;

import org.foodbank.fooddonation.infrastructure.persistence.Packet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<Packet, Long> {
}
