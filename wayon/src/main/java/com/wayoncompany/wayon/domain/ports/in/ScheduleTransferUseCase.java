package com.wayoncompany.wayon.domain.ports.in;

import com.wayoncompany.wayon.application.dto.TransferRequest;
import com.wayoncompany.wayon.application.dto.TransferResponse;

public interface ScheduleTransferUseCase {
    TransferResponse schedule(
            TransferRequest request);
}
