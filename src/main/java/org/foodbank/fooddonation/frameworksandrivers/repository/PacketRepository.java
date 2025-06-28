package org.foodbank.fooddonation.frameworksandrivers.repository;

import org.foodbank.fooddonation.frameworksandrivers.persistence.Packet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<Packet, Long> {
}
