package com.wayoncompany.wayon.application.usecase;

import com.wayoncompany.wayon.application.dto.TransferRequest;
import com.wayoncompany.wayon.application.dto.TransferResponse;
import com.wayoncompany.wayon.application.mapper.TransferMapper;
import com.wayoncompany.wayon.domain.exception.BusinessException;
import com.wayoncompany.wayon.domain.model.Transfer;
import com.wayoncompany.wayon.domain.service.FeeCalculator;
import com.wayoncompany.wayon.domain.ports.in.GetTransfersUseCase;
import com.wayoncompany.wayon.domain.ports.in.ScheduleTransferUseCase;
import com.wayoncompany.wayon.domain.ports.out.TransferRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferUseCaseService implements ScheduleTransferUseCase,
        GetTransfersUseCase {

    private final TransferRepositoryPort repository;

    private final FeeCalculator feeCalculator;

    private final TransferMapper mapper;

    @Override
    public TransferResponse schedule(
            TransferRequest request) {

        long days =
                ChronoUnit.DAYS.between(
                        LocalDate.now(),
                        request.getTransferDate()
                );

        if (days < 0) {

            throw new BusinessException(
                    "Transfer date cannot be in the past."
            );
        }

        BigDecimal fee =
                feeCalculator.calculate(
                        request.getAmount(),
                        days
                );

        Transfer transfer =
                Transfer.builder()
                        .sourceAccount(
                                request.getSourceAccount())
                        .destinationAccount(
                                request.getDestinationAccount())
                        .amount(
                                request.getAmount())
                        .fee(fee)
                        .totalAmount(
                                request.getAmount()
                                        .add(fee))
                        .transferDate(
                                request.getTransferDate())
                        .scheduleDate(
                                LocalDate.now())
                        .build();

        Transfer savedTransfer =
                repository.save(
                        transfer);

        return mapper.toResponse(
                savedTransfer);
    }

    @Override
    public List<TransferResponse> findAll() {

        return mapper.toResponseList(
                repository.findAll());
    }
}
