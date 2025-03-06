package com.example.calculateservice.calculator.impl;

import java.math.*;
import java.time.*;

import com.example.calculateservice.calculator.AbstractCalculator;
import com.example.calculateservice.calculator.CalculatorParams;
import com.example.calculateservice.calculator.CapitalizationType;
import org.springframework.stereotype.*;

@Component
public class YearlyCapitalizationCalculator extends AbstractCalculator {

    @Override
    public CapitalizationType getType() {
        return CapitalizationType.YEARLY;
    }

    @Override
    public BigDecimal calculate(CalculatorParams calculatorParams) {

        LocalDate startDate = calculatorParams.getStartDate();
        int period = calculatorParams.getPeriod();
        BigDecimal sum = calculatorParams.getSum();
        BigDecimal percent = calculatorParams.getPercent();

        var startPeriod = startDate;
        var endPeriod = startPeriod.plusYears(1);
        var totalIncome = BigDecimal.ZERO;
        var iterations = period / 365;

        for (int i = 0; i < iterations; i++) {

            var result = calculateOldNewYearIteration(
                    startPeriod,
                    sum,
                    totalIncome,
                    percent,
                    endPeriod
            );
            totalIncome = result.getIncome();
            sum = result.getCurrentSum();

            startPeriod = endPeriod.plusDays(1);
            endPeriod = startPeriod.plusYears(1).minusDays(1);
        }

        return totalIncome;
    }

}
