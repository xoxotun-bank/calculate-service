package com.example.calculateservice.component.predicate;

import com.example.calculateservice.swagger.client.abs.model.AbsFinancialProductDto;
import com.example.calculateservice.swagger.server.model.FinancialProductsParams;

public interface FinancialProductPredicate {

    boolean check(
            FinancialProductsParams params,
            AbsFinancialProductDto dto
    );

    boolean isRequired();

    CurrentField getCurrentField();

}