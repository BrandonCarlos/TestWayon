package com.wayoncompany.wayon.domain.ports.in;

import com.wayoncompany.wayon.application.dto.TransferResponse;

import java.util.List;

public interface GetTransfersUseCase {
    List<TransferResponse> findAll();
}
