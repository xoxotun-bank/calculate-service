package com.example.calculateservice.controller;

import java.math.*;
import java.time.*;
import java.util.*;

import com.example.calculateservice.exceptions.ProductsNotFoundException;
import com.example.calculateservice.service.MonthPaymentCalculatorService;
import com.example.calculateservice.swagger.server.api.PaymentsTablesApi;
import com.example.calculateservice.swagger.server.model.PaymentsTableResponseDto;
import com.fasterxml.jackson.databind.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/calculator")
@RequiredArgsConstructor
public class PaymentsTablesController implements PaymentsTablesApi {

    private static final String MONTHLY = "Ежемесячно";

    private final MonthPaymentCalculatorService monthPaymentCalculatorService;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    @PreAuthorize("hasRole('operator')")
    public ResponseEntity<PaymentsTableResponseDto> paymentsTablesGet(
        Boolean capitalizationToSameAccount,
        String capitalizationPeriod,
        BigDecimal sum,
        Integer period,
        BigDecimal percent
    ) {
        validateRequest(capitalizationPeriod, capitalizationToSameAccount);

        var start = LocalDate.now();
        var response = monthPaymentCalculatorService.calculatePayments(start, sum, period, percent);
        return ResponseEntity.ok(response);
    }

    private void validateRequest(String capitalizationPeriod, Boolean capitalizationToSameAccount) {
        if (capitalizationToSameAccount || !capitalizationPeriod.equals(MONTHLY)) {
            throw new ProductsNotFoundException();
        }
    }

}
