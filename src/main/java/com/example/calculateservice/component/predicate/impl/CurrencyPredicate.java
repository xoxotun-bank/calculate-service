package com.example.calculateservice.component.predicate.impl;

import org.springframework.stereotype.*;

import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.swagger.client.abs.model.*;
import com.example.calculateservice.swagger.server.model.*;

@Component
public class CurrencyPredicate implements FinancialProductPredicate {

    @Override
    public boolean check(FinancialProductsParams params, AbsFinancialProductDto dto) {
        var paramCurrency = params.getCurrency();
        var dtoCurrency = dto.getFinancialProduct().getCurrency();

        return paramCurrency == null || paramCurrency.equals(dtoCurrency);
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
