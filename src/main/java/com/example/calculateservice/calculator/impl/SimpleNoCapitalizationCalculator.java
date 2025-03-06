package com.example.calculateservice.calculator.impl;

import java.math.*;
import java.time.*;
import java.time.temporal.*;

import com.example.calculateservice.calculator.AbstractCalculator;
import com.example.calculateservice.calculator.CalculatorParams;
import com.example.calculateservice.calculator.CapitalizationType;
import org.springframework.stereotype.*;

@Component
public class SimpleNoCapitalizationCalculator extends AbstractCalculator {

    @Override
    public CapitalizationType getType() {
        return CapitalizationType.SIMPLE;
    }

    @Override
    public BigDecimal calculate(CalculatorParams calculatorParams) {
        LocalDate startDate = calculatorParams.getStartDate();
        int period = calculatorParams.getPeriod();
        BigDecimal sum = calculatorParams.getSum();
        BigDecimal percent = calculatorParams.getPercent();

        var endDate = startDate.plusDays(period);

        if (startDate.getYear() == endDate.getYear()) {
            return formula(
                    period,
                    sum,
                    percent,
                    startDate.lengthOfYear());
        }
        var startPeriod = startDate;
        LocalDate periodEnd = LocalDate.of(startPeriod.getYear(), 12, 31);
        int daysInPeriod = (int) ChronoUnit.DAYS.between(startPeriod, periodEnd);

        BigDecimal totalIncome = formula(
                daysInPeriod,
                sum,
                percent,
                startPeriod.lengthOfYear());
        startPeriod = periodEnd;
        periodEnd = LocalDate.of(startPeriod.getYear() + 1, 12, 31);

        while (startPeriod.isBefore(endDate)) {
            if (periodEnd.isAfter(endDate)) {
                periodEnd = endDate;
            }

            daysInPeriod = (int) ChronoUnit.DAYS.between(startPeriod, periodEnd);
            BigDecimal income = formula(
                    daysInPeriod,
                    sum,
                    percent,
                    periodEnd.lengthOfYear());
            totalIncome = totalIncome.add(income);

            startPeriod = periodEnd.plusDays(1);
            periodEnd = LocalDate.of(startPeriod.getYear(), 12, 31);

        }

        return totalIncome;
    }

}
