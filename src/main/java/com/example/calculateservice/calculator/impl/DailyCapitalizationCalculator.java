package com.example.calculateservice.calculator.impl;

import java.math.*;
import java.time.*;
import java.time.temporal.*;

import com.example.calculateservice.calculator.AbstractCalculator;
import com.example.calculateservice.calculator.CalculatorParams;
import com.example.calculateservice.calculator.CapitalizationType;
import org.springframework.stereotype.*;

@Component
public class DailyCapitalizationCalculator extends AbstractCalculator {

    @Override
    public CapitalizationType getType() {
        return CapitalizationType.DAILY;
    }

    @Override
    public BigDecimal calculate(CalculatorParams calculatorParams) {

        LocalDate startDate = calculatorParams.getStartDate();
        int period = calculatorParams.getPeriod();
        BigDecimal sum = calculatorParams.getSum();
        BigDecimal percent = calculatorParams.getPercent();

        var endDate = startDate.plusDays(period);
        if (endDate.getYear() == startDate.getYear()) {
            var result = formula(
                    period,
                    sum,
                    percent,
                    startDate.lengthOfYear());
            result = result.subtract(sum);
            return result;
        }

        var startPeriod = startDate;
        LocalDate periodEnd = LocalDate.of(startPeriod.getYear(), 12, 31);
        int daysInPeriod = (int) ChronoUnit.DAYS.between(startPeriod, periodEnd);

        BigDecimal current = formula(
                daysInPeriod,
                sum,
                percent,
                startPeriod.lengthOfYear());

        startPeriod = periodEnd.plusDays(1);
        periodEnd = LocalDate.of(startPeriod.getYear(), 12, 31);
        while (startPeriod.isBefore(endDate)) {
            if (periodEnd.isAfter(endDate)) {
                periodEnd = endDate;
            }

            daysInPeriod = (int) ChronoUnit.DAYS.between(startPeriod, periodEnd) + 1;
            current = formula(
                    daysInPeriod,
                    current,
                    percent,
                    startPeriod.lengthOfYear());

            startPeriod = periodEnd.plusDays(1);
            periodEnd = LocalDate.of(startPeriod.getYear(), 12, 31);

        }
        var result = current.subtract(sum);
        return result;
    }

    /**
     * Формула подсчёта сложного процента <br>
     * profit = sum * Math.pow((1 + percent / 100 / daysInYear), period) <br>
     *
     * @param daysInYear - кол-во дней в году
     * @param period - срок периода
     * @param sum - сумма вклада
     * @param percent - процентаня ставка
     *
     * @return profit
     */
    @Override
    protected BigDecimal formula(
            int period,
            BigDecimal sum,
            BigDecimal percent,
            int daysInYear
    ) {

        var daysInYearBigDecimal = new BigDecimal(daysInYear);
        var hundred = new BigDecimal(100);
        var one = BigDecimal.ONE;

        var result = percent.divide(hundred, MathContext.DECIMAL128);
        result = result.divide(daysInYearBigDecimal, MathContext.DECIMAL128);
        result = result.add(one);
        result = result.pow(period);
        result = sum.multiply(result);

        return result;

    }

}
