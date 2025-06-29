package org.foodbank.fooddonation.infrastructure.packet.repository;

import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketProductId;
import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketProductPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketProductRepository extends JpaRepository<PacketProductPersistence, PacketProductId> {
}
