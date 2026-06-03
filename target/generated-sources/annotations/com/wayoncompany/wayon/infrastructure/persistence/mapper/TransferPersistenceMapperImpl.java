package com.wayoncompany.wayon.infrastructure.persistence.mapper;

import com.wayoncompany.wayon.domain.model.Transfer;
import com.wayoncompany.wayon.infrastructure.persistence.entity.TransferEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-02T21:37:13-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class TransferPersistenceMapperImpl implements TransferPersistenceMapper {

    @Override
    public TransferEntity toEntity(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        TransferEntity.TransferEntityBuilder transferEntity = TransferEntity.builder();

        transferEntity.id( transfer.getId() );
        transferEntity.sourceAccount( transfer.getSourceAccount() );
        transferEntity.destinationAccount( transfer.getDestinationAccount() );
        transferEntity.amount( transfer.getAmount() );
        transferEntity.fee( transfer.getFee() );
        transferEntity.totalAmount( transfer.getTotalAmount() );
        transferEntity.transferDate( transfer.getTransferDate() );
        transferEntity.scheduleDate( transfer.getScheduleDate() );

        return transferEntity.build();
    }

    @Override
    public Transfer toDomain(TransferEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Transfer.TransferBuilder transfer = Transfer.builder();

        transfer.id( entity.getId() );
        transfer.sourceAccount( entity.getSourceAccount() );
        transfer.destinationAccount( entity.getDestinationAccount() );
        transfer.amount( entity.getAmount() );
        transfer.fee( entity.getFee() );
        transfer.totalAmount( entity.getTotalAmount() );
        transfer.transferDate( entity.getTransferDate() );
        transfer.scheduleDate( entity.getScheduleDate() );

        return transfer.build();
    }

    @Override
    public List<Transfer> toDomainList(List<TransferEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Transfer> list = new ArrayList<Transfer>( entities.size() );
        for ( TransferEntity transferEntity : entities ) {
            list.add( toDomain( transferEntity ) );
        }

        return list;
    }
}
