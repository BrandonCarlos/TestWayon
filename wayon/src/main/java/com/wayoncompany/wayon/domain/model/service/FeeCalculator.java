package com.wayoncompany.wayon.domain.model.service;

import com.wayoncompany.wayon.domain.model.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class FeeCalculator {

    public BigDecimal calculate(
            BigDecimal amount,
            long days) {

        if (days == 0) {

            return amount
                    .multiply(BigDecimal.valueOf(0.025))
                    .add(BigDecimal.valueOf(3))
                    .setScale(2, RoundingMode.HALF_UP);
        }

        if (days >= 1 && days <= 10) {
            return BigDecimal.valueOf(12.00);
        }

        if (days >= 11 && days <= 20) {

            return amount
                    .multiply(BigDecimal.valueOf(0.082))
                    .setScale(2, RoundingMode.HALF_UP);
        }

        if (days >= 21 && days <= 30) {

            return amount
                    .multiply(BigDecimal.valueOf(0.069))
                    .setScale(2, RoundingMode.HALF_UP);
        }

        if (days >= 31 && days <= 40) {

            return amount
                    .multiply(BigDecimal.valueOf(0.047))
                    .setScale(2, RoundingMode.HALF_UP);
        }

        if (days >= 41 && days <= 50) {

            return amount
                    .multiply(BigDecimal.valueOf(0.017))
                    .setScale(2, RoundingMode.HALF_UP);
        }

        throw new BusinessException(
                "No applicable fee for the informed transfer date."
        );
    }
}
