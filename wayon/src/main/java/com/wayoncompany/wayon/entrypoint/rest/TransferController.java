package com.wayoncompany.wayon.entrypoint.rest;

import com.wayoncompany.wayon.application.dto.TransferRequest;
import com.wayoncompany.wayon.application.dto.TransferResponse;
import com.wayoncompany.wayon.domain.ports.in.GetTransfersUseCase;
import com.wayoncompany.wayon.domain.ports.in.ScheduleTransferUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
@Validated
public class TransferController {

    private final ScheduleTransferUseCase scheduleTransferUseCase;

    private final GetTransfersUseCase getTransfersUseCase;

    @PostMapping
    public TransferResponse schedule(
            @Valid
            @RequestBody
            TransferRequest request) {

        return scheduleTransferUseCase
                .schedule(request);
    }

    @GetMapping
    public List<TransferResponse> findAll() {

        return getTransfersUseCase
                .findAll();
    }

}
