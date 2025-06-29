package org.foodbank.fooddonation.infrastructure.packet.repository;

import org.foodbank.fooddonation.infrastructure.packet.persistence.PacketPersistence;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PacketRepository extends JpaRepository<PacketPersistence, Long> {


    @Query("SELECT DISTINCT p FROM PacketPersistence p " +
            "LEFT JOIN FETCH p.packetProductPersistences ppp " +
            "LEFT JOIN FETCH ppp.productPersistence " +
            "WHERE p.id = :id")
    Optional<PacketPersistence> findByIdWithProducts(Long id);

    @Query("SELECT DISTINCT p FROM PacketPersistence p " +
            "LEFT JOIN FETCH p.packetProductPersistences ppp " +
            "LEFT JOIN FETCH ppp.productPersistence")
    List<PacketPersistence> findAllWithProducts();

}
