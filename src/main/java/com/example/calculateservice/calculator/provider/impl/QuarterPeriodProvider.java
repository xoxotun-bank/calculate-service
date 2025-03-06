package com.example.calculateservice.calculator.provider.impl;

import java.time.*;

import com.example.calculateservice.calculator.provider.PeriodProvider;
import org.springframework.stereotype.*;
import com.example.calculateservice.calculator.Period;

@Component
public class QuarterPeriodProvider implements PeriodProvider {

    @Override
    public Period getPeriod(int i, LocalDate startDate) {
        var startPeriod = startDate.plusMonths(i * 3);
        var endPeriod = startDate.plusMonths((i + 1) * 3);

        return new Period(startPeriod, endPeriod);
    }

}
