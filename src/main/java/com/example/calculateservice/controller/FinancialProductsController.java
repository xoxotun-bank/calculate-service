package com.example.calculateservice.controller;

import java.math.*;
import java.util.*;

import com.example.calculateservice.component.receiver.FinancialProductReceiver;
import com.example.calculateservice.service.ProfitService;
import com.example.calculateservice.swagger.client.abs.model.FinancialProductsResponseDto;
import com.example.calculateservice.swagger.server.api.FinancialProductsApi;
import com.example.calculateservice.swagger.server.model.CalculatedProductsResponseDto;
import com.example.calculateservice.swagger.server.model.FinancialProductsParams;
import com.fasterxml.jackson.databind.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/calculator")
@RequiredArgsConstructor
public class FinancialProductsController implements FinancialProductsApi {

    private final FinancialProductReceiver receiver;

    private final ProfitService profitService;

    @Override
    @PreAuthorize("hasRole('operator')")
    public ResponseEntity<CalculatedProductsResponseDto> financialProductsGet(
        BigDecimal sum,
        List<String> categories,
        String currency,
        List<Integer> periods,
        Boolean canDeposit,
        Boolean canWithdrawal,
        Boolean capitalizationToSameAccount,
        List<String> capitalizationPeriods
    ) {
        var financialProductsParams = new FinancialProductsParams();

        financialProductsParams.setSum(sum);
        financialProductsParams.setCategories(categories);
        financialProductsParams.setCurrency(currency);
        financialProductsParams.setPeriods(periods);
        financialProductsParams.setCanDeposit(canDeposit);
        financialProductsParams.setCanWithdrawal(canWithdrawal);
        financialProductsParams.setCapitalizationToSameAccount(capitalizationToSameAccount);
        financialProductsParams.setCapitalizationPeriods(capitalizationPeriods);

        var rawProducts = receiver
            .getFinancialProducts(financialProductsParams);

        var calculatedProducts = profitService
            .calculate(rawProducts, financialProductsParams.getSum());

        var response = new CalculatedProductsResponseDto();
        response.setProducts(calculatedProducts);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<FinancialProductsResponseDto> financialProductsGet() {
        return null;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

}
