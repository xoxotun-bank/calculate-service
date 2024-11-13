package com.example.calculateservice.calculator.provider.impl;

import java.time.*;

import com.example.calculateservice.calculator.provider.PeriodProvider;
import com.example.calculateservice.calculator.Period;
import org.springframework.stereotype.*;


@Component
public class MonthPeriodProvider implements PeriodProvider {

    @Override
    public Period getPeriod(int i, LocalDate startDate) {
        var startPeriod = startDate.plusMonths(i);
        var endPeriod = startDate.plusMonths(i + 1);

        return new Period(startPeriod, endPeriod);
    }

}
