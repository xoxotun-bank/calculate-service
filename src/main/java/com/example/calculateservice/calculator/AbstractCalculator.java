package com.example.calculateservice.calculator;

import java.math.*;
import java.time.*;
import java.time.temporal.*;

import lombok.*;

public abstract class AbstractCalculator {

    public abstract BigDecimal calculate(CalculatorParams calculatorParams);

    /**
     * Формула подсчёта простого процента <br>
     * result = (sum *  percent * period) / daysInYear) / 100 <br>
     *
     * @param period - срок периода
     * @param sum - сумма вклада
     * @param percent - процентаня ставка
     * @param daysInYear - кол-во дней в году
     *
     * @return result
     */
    protected BigDecimal formula(
            int period,
            BigDecimal sum,
            BigDecimal percent,
            int daysInYear
    ) {
        var periodBigDecimal = new BigDecimal(period);
        var daysInYearBigDecimal = new BigDecimal(daysInYear);
        var result = sum.multiply(percent);
        result = result.multiply(periodBigDecimal);
        result = result.divide(daysInYearBigDecimal, MathContext.DECIMAL128);
        result = result.divide(BigDecimal.valueOf(100), MathContext.DECIMAL128);
        return result;
    }

    public abstract CapitalizationType getType();

    /**
     * Подсчёт прибыли при смене года. Необходимо из-за изменения количества дней в году<br>
     *
     * @param startPeriod
     * @param currentSum
     * @param totalIncome
     * @param percent
     * @param endPeriod
     *
     * @return
     */
    protected IterationParameters calculateOldNewYearIteration(
            LocalDate startPeriod,
            BigDecimal currentSum,
            BigDecimal totalIncome,
            BigDecimal percent,
            LocalDate endPeriod
    ) {
        var startPeriodLocal = startPeriod;
        var totalIncomeLocal = totalIncome;
        var daysInPeriod = 0;
        var currentSumLocal = currentSum;
        var tempEndPeriod = LocalDate.of(startPeriodLocal.getYear(), 12, 31);
        IterationParameters iter1 = calculateIteration(
                startPeriodLocal,
                currentSumLocal,
                totalIncome,
                percent,
                tempEndPeriod);
        totalIncomeLocal = totalIncome.add(iter1.getIncome());
        daysInPeriod += iter1.getPeriod();
        startPeriodLocal = tempEndPeriod;

        IterationParameters iter2 = calculateIteration(
                startPeriodLocal,
                currentSumLocal,
                totalIncome,
                percent,
                endPeriod);

        currentSumLocal = currentSumLocal.add(iter1.getIncome());
        startPeriodLocal = iter2.getStartPeriod();
        totalIncomeLocal = totalIncomeLocal.add(iter2.getIncome());
        currentSumLocal = currentSumLocal.add(iter2.getIncome());
        daysInPeriod += iter2.getPeriod();
        startPeriodLocal = startPeriodLocal.plusDays(iter2.getPeriod());

        var newIterParams = new IterationParameters(
                startPeriodLocal,
                daysInPeriod,
                currentSumLocal,
                totalIncomeLocal);
        return newIterParams;
    }

    /**
     * Просчитывает доходность с одной итерации
     *
     * @param startPeriod
     * @param currentSum
     * @param totalIncome
     * @param percent
     * @param endPeriod
     *
     * @return
     */
    protected IterationParameters calculateIteration(
            LocalDate startPeriod,
            BigDecimal currentSum,
            BigDecimal totalIncome,
            BigDecimal percent,
            LocalDate endPeriod
    ) {
        LocalDate start = startPeriod;

        int daysInPeriod = (int) ChronoUnit.DAYS.between(start, endPeriod);

        var income = formula(
                daysInPeriod,
                currentSum,
                percent,
                endPeriod.lengthOfYear());

        var newSum = currentSum.add(income);

        var newIterParams = new IterationParameters(
                start,
                daysInPeriod,
                newSum,
                income);
        return newIterParams;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IterationParameters {

        private LocalDate startPeriod;

        private int period;

        private BigDecimal currentSum;

        private BigDecimal income;

    }

}
