package com.wayoncompany.wayon.domain.service;

import com.wayoncompany.wayon.domain.exception.BusinessException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class FeeCalculatorTest {

    private final FeeCalculator calculator =
            new FeeCalculator();

    @Test
    void shouldCalculateSameDayTransferFee() {

        BigDecimal fee =
                calculator.calculate(
                        BigDecimal.valueOf(1000),
                        0
                );

        assertEquals(
                BigDecimal.valueOf(28.00)
                        .setScale(2),
                fee
        );
    }

    @Test
    void shouldCalculateOneToTenDaysFee() {

        BigDecimal fee =
                calculator.calculate(
                        BigDecimal.valueOf(1000),
                        5
                );

        assertEquals(
                0,
                BigDecimal.valueOf(12.00)
                        .compareTo(fee)
        );
    }

    @Test
    void shouldCalculateElevenToTwentyDaysFee() {

        BigDecimal fee =
                calculator.calculate(
                        BigDecimal.valueOf(1000),
                        15
                );

        assertEquals(
                BigDecimal.valueOf(82.00)
                        .setScale(2),
                fee
        );
    }

    @Test
    void shouldCalculateTwentyOneToThirtyDaysFee() {

        BigDecimal fee =
                calculator.calculate(
                        BigDecimal.valueOf(1000),
                        25
                );

        assertEquals(
                BigDecimal.valueOf(69.00)
                        .setScale(2),
                fee
        );
    }

    @Test
    void shouldCalculateThirtyOneToFortyDaysFee() {

        BigDecimal fee =
                calculator.calculate(
                        BigDecimal.valueOf(1000),
                        35
                );

        assertEquals(
                BigDecimal.valueOf(47.00)
                        .setScale(2),
                fee
        );
    }

    @Test
    void shouldCalculateFortyOneToFiftyDaysFee() {

        BigDecimal fee =
                calculator.calculate(
                        BigDecimal.valueOf(1000),
                        45
                );

        assertEquals(
                BigDecimal.valueOf(17.00)
                        .setScale(2),
                fee
        );
    }

    @Test
    void shouldThrowExceptionWhenFeeDoesNotExist() {

        assertThrows(
                BusinessException.class,
                () -> calculator.calculate(
                        BigDecimal.valueOf(1000),
                        60
                )
        );
    }
}
