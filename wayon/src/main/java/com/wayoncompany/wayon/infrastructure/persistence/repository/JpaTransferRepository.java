package com.wayoncompany.wayon.infrastructure.persistence.repository;

import com.wayoncompany.wayon.infrastructure.persistence.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTransferRepository extends JpaRepository<TransferEntity, Long> {
}
