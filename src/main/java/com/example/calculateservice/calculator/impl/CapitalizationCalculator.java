package com.example.calculateservice.calculator.impl;

import java.math.*;
import java.time.*;
import java.time.temporal.*;

import com.example.calculateservice.calculator.AbstractCalculator;
import com.example.calculateservice.calculator.CalculatorParams;
import com.example.calculateservice.calculator.CapitalizationType;
import com.example.calculateservice.calculator.provider.PeriodProvider;
import lombok.*;

@RequiredArgsConstructor
public class CapitalizationCalculator extends AbstractCalculator {

    private final PeriodProvider periodProvider;

    private final CapitalizationType capitalizationType;

    @Override
    public CapitalizationType getType() {
        return capitalizationType;
    }

    @Override
    public BigDecimal calculate(CalculatorParams calculatorParams) {
        LocalDate startDate = calculatorParams.getStartDate();
        int period = calculatorParams.getPeriod();
        BigDecimal sum = calculatorParams.getSum();
        BigDecimal percent = calculatorParams.getPercent();
        var endDate = startDate.plusDays(period);

        BigDecimal totalIncome = BigDecimal.ZERO;

        var currentSum = sum;
        var daysInPeriod = 0;

        int i = 0;
        while (i >= 0) {
            var periods = periodProvider.getPeriod(i, startDate);

            var startPeriod = periods.start();
            var endPeriod = periods.end();

            i++;
            if (endPeriod.isAfter(endDate)) {
                endPeriod = endDate;
                i = Integer.MIN_VALUE;
            }

            if (startPeriod.getYear() < endPeriod.getYear()) {
                var result = calculateOldNewYearIteration(
                        startPeriod,
                        currentSum,
                        totalIncome,
                        percent,
                        endPeriod);

                totalIncome = result.getIncome();
                currentSum = result.getCurrentSum();

                continue;
            }

            daysInPeriod = (int) ChronoUnit.DAYS.between(startPeriod, endPeriod);

            var income = formula(daysInPeriod, currentSum, percent, startPeriod.lengthOfYear());
            totalIncome = totalIncome.add(income);
            currentSum = currentSum.add(income);

        }

        return totalIncome;
    }

}
