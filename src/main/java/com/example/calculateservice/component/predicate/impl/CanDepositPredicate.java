package com.example.calculateservice.component.predicate.impl;

import org.springframework.stereotype.*;

import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.swagger.client.abs.model.*;
import com.example.calculateservice.swagger.server.model.*;

@Component
public class CanDepositPredicate implements FinancialProductPredicate {

    @Override
    public boolean check(FinancialProductsParams params, AbsFinancialProductDto dto) {
        var paramCanDeposit = params.isCanDeposit();
        var dtoCanDeposit = dto.getFinancialProduct().isCanDeposit();

        var result = paramCanDeposit == null || paramCanDeposit.equals(dtoCanDeposit);

        return result;
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public CurrentField getCurrentField() {
        return CurrentField.CAN_DEPOSIT;
    }

}
