package com.example.calculateservice.service;

import java.math.*;
import java.time.*;
import java.util.*;

import com.example.calculateservice.calculator.CalculatorParams;
import com.example.calculateservice.component.wrapper.ScoredProductDto;
import lombok.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;

import com.example.calculateservice.calculator.*;
import com.example.calculateservice.swagger.server.model.CalculatedProductDto;

@Service
@RequiredArgsConstructor
public class ProfitService {

    private final CalculatorFactory calculatorFactory;

    private final ModelMapper mapper;

    public List<CalculatedProductDto> calculate(
            List<ScoredProductDto> financialProductDtoList,
            BigDecimal sum
    ) {
        var startDate = LocalDate.now();
        var result = financialProductDtoList.stream()
                .map(productDto -> calculateProduct(productDto, startDate, sum))
                .sorted(Comparator.comparing(ScoredProductDto::getMatchCount)
                        .thenComparing(CalculatedProductDto::getProfit)
                        .reversed()
                )
                .map(productDto -> mapper.map(productDto, CalculatedProductDto.class))
                .toList();
        return result;

    }

    private ScoredProductDto calculateProduct(
            ScoredProductDto scoredProductDto,
            LocalDate startDate,
            BigDecimal sum
    ) {
        var product = scoredProductDto.getFinancialProduct();
        var period = product.getPeriod();
        var percent = product.getPercent();
        var capitalization = product.isCapitalizationToSameAccount();
        var capitalizationPeriod = product.getCapitalizationPeriod();

        var calculator = calculatorFactory.getCalculator(
                capitalization,
                capitalizationPeriod
        );
        var params = new CalculatorParams(startDate, period, sum, percent);
        BigDecimal profit = calculator.calculate(params);
        var newSum = sum.add(profit);
        var profitInPercent = newSum.divide(sum, MathContext.DECIMAL128)
                .subtract(BigDecimal.ONE)
                .multiply(new BigDecimal(100));
        scoredProductDto.setProfit(profit);
        scoredProductDto.setProfitInPercent(profitInPercent);

        return scoredProductDto;
    }

}