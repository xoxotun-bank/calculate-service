package com.example.calculateservice.calculator;

import java.math.*;
import java.time.*;

import lombok.*;

@AllArgsConstructor
@Getter
public class CalculatorParams {

    private LocalDate startDate;

    private int period;

    private BigDecimal sum;

    private BigDecimal percent;

}
