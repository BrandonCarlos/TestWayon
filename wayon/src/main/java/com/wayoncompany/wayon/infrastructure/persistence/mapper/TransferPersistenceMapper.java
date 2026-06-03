package com.wayoncompany.wayon.infrastructure.persistence.mapper;

import com.wayoncompany.wayon.domain.model.Transfer;
import com.wayoncompany.wayon.infrastructure.persistence.entity.TransferEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransferPersistenceMapper {
    TransferEntity toEntity(
            Transfer transfer);

    Transfer toDomain(
            TransferEntity entity);

    List<Transfer> toDomainList(
            List<TransferEntity> entities);
}
