package com.example.calculateservice.calculator.provider;

import java.time.*;

import com.example.calculateservice.calculator.Period;

public interface PeriodProvider {

    Period getPeriod(int i, LocalDate startDate);
}
