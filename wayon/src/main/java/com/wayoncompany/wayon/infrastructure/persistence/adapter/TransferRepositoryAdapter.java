package com.wayoncompany.wayon.infrastructure.persistence.adapter;

import com.wayoncompany.wayon.domain.model.Transfer;
import com.wayoncompany.wayon.domain.ports.out.TransferRepositoryPort;
import com.wayoncompany.wayon.infrastructure.persistence.entity.TransferEntity;
import com.wayoncompany.wayon.infrastructure.persistence.mapper.TransferPersistenceMapper;
import com.wayoncompany.wayon.infrastructure.persistence.repository.JpaTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransferRepositoryAdapter implements TransferRepositoryPort {

    private final JpaTransferRepository repository;

    private final TransferPersistenceMapper mapper;

    @Override
    public Transfer save(
            Transfer transfer) {

        TransferEntity entity =
                mapper.toEntity(
                        transfer);

        TransferEntity savedEntity =
                repository.save(
                        entity);

        return mapper.toDomain(
                savedEntity);
    }

    @Override
    public List<Transfer> findAll() {

        return mapper.toDomainList(
                repository.findAll());
    }
}