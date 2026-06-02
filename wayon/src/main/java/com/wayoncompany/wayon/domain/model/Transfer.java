package com.wayoncompany.wayon.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
    private Long id;

    private String sourceAccount;

    private String destinationAccount;

    private BigDecimal amount;

    private BigDecimal fee;

    private BigDecimal totalAmount;

    private LocalDate transferDate;

    private LocalDate scheduleDate;
}
