package com.example.calculateservice.component.receiver.impl;

import java.util.*;

import com.example.calculateservice.component.FinancialProductsClientCacheable;
import com.example.calculateservice.component.wrapper.*;
import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.component.receiver.*;
import com.example.calculateservice.exceptions.ProductsNotFoundException;
import com.example.calculateservice.swagger.server.model.FinancialProductDto;
import com.example.calculateservice.swagger.server.model.*;
import com.example.calculateservice.swagger.client.abs.model.*;

import com.fasterxml.jackson.databind.*;
import lombok.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;


@Component
@RequiredArgsConstructor
public class AbsProductReceiver implements FinancialProductReceiver {

    private final FinancialProductsClientCacheable absClient;

    private final ModelMapper mapper;

    private final ObjectMapper objectMapper;

    private final List<FinancialProductPredicate> predicates;

    @Override
    public List<ScoredProductDto> getFinancialProducts(FinancialProductsParams calculatorParams) {

        var rawResponse = absClient.financialProductsGet();

        if (rawResponse == null || rawResponse.getBody() == null ||
                rawResponse.getBody().getProducts().isEmpty()) {
            throw new ProductsNotFoundException();
        }

        var rawAbsProducts = rawResponse.getBody().getProducts();

        List<ScoredProductDto> calculatorProducts = rawAbsProducts.stream()
                .map(absDto -> getScoredProduct(calculatorParams, absDto))
                .filter(dto -> dto.getMatchCount() > 0)
                .toList();

        if (calculatorProducts.isEmpty()) {
            throw new ProductsNotFoundException();
        }

        return calculatorProducts;
    }

    private ScoredProductDto getScoredProduct(
            FinancialProductsParams calculatorParams,
            AbsFinancialProductDto absDto
    ) {

        Map<String, Boolean> matchesParams = new HashMap<>();
        int matchCount = 0;

        for (var predicate : predicates) {
            var result = predicate.check(calculatorParams, absDto);
            if (predicate.isRequired() && !result) {
                matchCount = 0;
                break;
            }
            if (!predicate.isRequired()) {
                matchesParams.put(predicate.getCurrentField().getName(), result);
                if (result) {
                    matchCount++;
                }
            }

        }
        var matches = objectMapper.convertValue(matchesParams, MatchesParametersDto.class);
        var scoredProduct = new ScoredProductDto();

        var absProduct = absDto.getFinancialProduct();
        var calculatorProduct = mapper.map(absProduct, FinancialProductDto.class);

        scoredProduct.setFinancialProduct(calculatorProduct);
        scoredProduct.setMatchesParameters(matches);
        scoredProduct.setMatchCount(matchCount);
        return scoredProduct;
    }
}
