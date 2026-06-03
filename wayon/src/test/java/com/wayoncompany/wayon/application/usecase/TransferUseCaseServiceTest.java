package com.wayoncompany.wayon.application.usecase;

import com.wayoncompany.wayon.application.dto.TransferRequest;
import com.wayoncompany.wayon.application.mapper.TransferMapper;
import com.wayoncompany.wayon.domain.model.Transfer;
import com.wayoncompany.wayon.domain.ports.out.TransferRepositoryPort;
import com.wayoncompany.wayon.domain.service.FeeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class TransferUseCaseServiceTest {

    private TransferRepositoryPort repository;

    private TransferUseCaseService service;

    @BeforeEach
    void setup() {

        repository =
                mock(TransferRepositoryPort.class);

        FeeCalculator feeCalculator =
                new FeeCalculator();

        TransferMapper mapper =
                Mappers.getMapper(
                        TransferMapper.class
                );

        service =
                new TransferUseCaseService(
                        repository,
                        feeCalculator,
                        mapper
                );
    }

    @Test
    void shouldScheduleTransfer() {

        TransferRequest request =
                new TransferRequest();

        request.setSourceAccount(
                "1234567890");

        request.setDestinationAccount(
                "0987654321");

        request.setAmount(
                BigDecimal.valueOf(1000));

        request.setTransferDate(
                LocalDate.now().plusDays(45)
        );

        when(repository.save(any()))
                .thenReturn(
                        Transfer.builder()
                                .id(1L)
                                .build()
                );

        service.schedule(request);

        verify(repository)
                .save(any());
    }

}
