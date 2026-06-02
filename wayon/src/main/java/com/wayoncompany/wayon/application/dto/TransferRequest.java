package com.wayoncompany.wayon.application.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransferRequest {
    @Pattern(
            regexp = "\\d{10}",
            message = "Source account must contain 10 digits"
    )
    private String sourceAccount;

    @Pattern(
            regexp = "\\d{10}",
            message = "Destination account must contain 10 digits"
    )
    private String destinationAccount;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

    @NotNull
    private LocalDate transferDate;
}
