package com.example.calculateservice.component.predicate.impl;

import org.springframework.stereotype.*;

import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.swagger.client.abs.model.*;
import com.example.calculateservice.swagger.server.model.*;

@Component
public class CapitalizationToSameAccountPredicate implements FinancialProductPredicate {

    @Override
    public boolean check(FinancialProductsParams params, AbsFinancialProductDto dto) {
        var paramCapitalizationToSameAccount = params.isCapitalizationToSameAccount();
        var dtoCapitalizationToSameAccount = dto.getFinancialProduct()
            .isCapitalizationToSameAccount();

        var result = paramCapitalizationToSameAccount == null || paramCapitalizationToSameAccount.equals(
            dtoCapitalizationToSameAccount);

        return result;
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public CurrentField getCurrentField() {
        return CurrentField.CAPITALIZATION_TO_SAME_ACCOUNT;
    }

}
