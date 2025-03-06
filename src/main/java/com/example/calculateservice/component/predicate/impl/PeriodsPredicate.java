package com.example.calculateservice.component.predicate.impl;

import org.springframework.stereotype.*;

import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.swagger.client.abs.model.*;
import com.example.calculateservice.swagger.server.model.*;

@Component
public class PeriodsPredicate implements FinancialProductPredicate {

    @Override
    public boolean check(FinancialProductsParams params, AbsFinancialProductDto dto) {
        var paramPeriods = params.getPeriods();
        var dtoPeriod = dto.getFinancialProduct().getPeriod();
        var result = paramPeriods == null || paramPeriods.contains(dtoPeriod);

        return result;
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public CurrentField getCurrentField() {
        return CurrentField.PERIOD;
    }

}
