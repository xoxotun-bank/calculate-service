package com.example.calculateservice.component.predicate.impl;

import org.springframework.stereotype.*;

import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.swagger.client.abs.model.*;
import com.example.calculateservice.swagger.server.model.*;

@Component
public class CapitalizationPeriodPredicate implements FinancialProductPredicate {

    @Override
    public boolean check(FinancialProductsParams params, AbsFinancialProductDto dto) {
        var paramCapitalizationPeriods = params.getCapitalizationPeriods();
        var dtoCapitalizationPeriod = dto.getFinancialProduct().getCapitalizationPeriod();

        var result = paramCapitalizationPeriods == null ||
                     paramCapitalizationPeriods.contains(dtoCapitalizationPeriod);

        return result;
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public CurrentField getCurrentField() {
        return CurrentField.CAPITALIZATION_PERIOD;
    }

}
