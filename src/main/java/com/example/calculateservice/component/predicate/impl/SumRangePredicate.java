package com.example.calculateservice.component.predicate.impl;

import org.springframework.stereotype.*;

import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.swagger.client.abs.model.*;
import com.example.calculateservice.swagger.server.model.*;

@Component
public class SumRangePredicate implements FinancialProductPredicate {

    @Override
    public boolean check(FinancialProductsParams params, AbsFinancialProductDto dto) {
        var sourceSum = params.getSum();

        var lowBoundSum = dto.getMinSum();
        var highBoundSum = dto.getMaxSum();

        return lowBoundSum.compareTo(sourceSum) <= 0 && sourceSum.compareTo(highBoundSum) <= 0;
    }

    @Override
    public boolean isRequired() {
        return true;
    }

    @Override
    public CurrentField getCurrentField() {
        return CurrentField.REQUIRED;
    }

}
