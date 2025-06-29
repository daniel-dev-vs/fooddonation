package org.foodbank.fooddonation.frameworksandrivers.packet.repository;

import org.foodbank.fooddonation.frameworksandrivers.packet.persistence.PacketPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<PacketPersistence, Long> {
}
