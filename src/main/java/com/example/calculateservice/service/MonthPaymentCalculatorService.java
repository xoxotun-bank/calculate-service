package com.example.calculateservice.service;

import java.math.*;
import java.time.*;
import java.time.temporal.*;

import com.example.calculateservice.calculator.CalculatorParams;
import com.example.calculateservice.calculator.impl.SimpleNoCapitalizationCalculator;
import com.example.calculateservice.swagger.server.model.PaymentDto;
import com.example.calculateservice.swagger.server.model.PaymentsTableResponseDto;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class MonthPaymentCalculatorService {

    private final SimpleNoCapitalizationCalculator calculator;

    public PaymentsTableResponseDto calculatePayments(
        LocalDate startDate,
        BigDecimal sum,
        Integer period,
        BigDecimal percent
    ) {
        PaymentsTableResponseDto response = new PaymentsTableResponseDto();

        var endDate = startDate.plusDays(period);
        int i = 0;

        while (i >= 0) {
            var newStart = startDate.plusMonths(i);
            var endPeriod = startDate.plusMonths(i + 1);
            i++;

            if (endPeriod.isAfter(endDate)) {
                endPeriod = endDate;
                i = Integer.MIN_VALUE;
            }

            var daysInPeriod = (int) ChronoUnit.DAYS.between(newStart, endPeriod);
            if (daysInPeriod == 0) {
                break;
            }

            var result = calculator.calculate(new CalculatorParams(
                newStart,
                daysInPeriod,
                sum,
                percent)
            );

            var paymentPercent = result.divide(sum, MathContext.DECIMAL128)
                .multiply(BigDecimal.valueOf(100));

            var payment = new PaymentDto();
            payment.setPaymentAmount(result);
            payment.setDate(endPeriod);
            payment.setPercent(paymentPercent);
            payment.setDaysAmount(daysInPeriod);

            response.addPaymentsItem(payment);

        }

        return response;
    }

}
