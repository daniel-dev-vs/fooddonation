package org.foodbank.fooddonation.infrastructure.packet.repository;

import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<PacketPersistence, Long> {
}
