package com.example.calculateservice.component.predicate.impl;

import org.springframework.stereotype.*;

import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.swagger.client.abs.model.*;
import com.example.calculateservice.swagger.server.model.*;

@Component
public class CanWithdrawalPredicate implements FinancialProductPredicate {

    @Override
    public boolean check(FinancialProductsParams params, AbsFinancialProductDto dto) {
        var paramCanWithdrawal = params.isCanWithdrawal();
        var dtoCanWithdrawal = dto.getFinancialProduct().isCanWithdrawal();

        var result = paramCanWithdrawal == null || paramCanWithdrawal.equals(dtoCanWithdrawal);

        return result;
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public CurrentField getCurrentField() {
        return CurrentField.CAN_WITHDRAWAL;
    }

}
