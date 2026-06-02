package com.wayoncompany.wayon.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponse {
    private Long id;

    private String sourceAccount;

    private String destinationAccount;

    private BigDecimal amount;

    private BigDecimal fee;

    private BigDecimal totalAmount;

    private LocalDate transferDate;

    private LocalDate scheduleDate;
}
