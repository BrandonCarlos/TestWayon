package com.wayoncompany.wayon.application.mapper;

import com.wayoncompany.wayon.application.dto.TransferResponse;
import com.wayoncompany.wayon.domain.model.Transfer;
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
public class TransferMapperImpl implements TransferMapper {

    @Override
    public TransferResponse toResponse(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        TransferResponse.TransferResponseBuilder transferResponse = TransferResponse.builder();

        transferResponse.id( transfer.getId() );
        transferResponse.sourceAccount( transfer.getSourceAccount() );
        transferResponse.destinationAccount( transfer.getDestinationAccount() );
        transferResponse.amount( transfer.getAmount() );
        transferResponse.fee( transfer.getFee() );
        transferResponse.totalAmount( transfer.getTotalAmount() );
        transferResponse.transferDate( transfer.getTransferDate() );
        transferResponse.scheduleDate( transfer.getScheduleDate() );

        return transferResponse.build();
    }

    @Override
    public List<TransferResponse> toResponseList(List<Transfer> transfers) {
        if ( transfers == null ) {
            return null;
        }

        List<TransferResponse> list = new ArrayList<TransferResponse>( transfers.size() );
        for ( Transfer transfer : transfers ) {
            list.add( toResponse( transfer ) );
        }

        return list;
    }
}
