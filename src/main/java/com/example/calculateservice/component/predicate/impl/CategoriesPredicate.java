package com.example.calculateservice.component.predicate.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.calculateservice.component.predicate.*;
import com.example.calculateservice.swagger.client.abs.model.*;
import com.example.calculateservice.swagger.server.model.*;

@Component
public class CategoriesPredicate implements FinancialProductPredicate {

    @Value("${whitelist.categories}")
    private String[] whiteList;

    @Override
    public boolean check(FinancialProductsParams params, AbsFinancialProductDto dto) {
        var paramCategories = params.getCategories();
        var dtoCategory = dto.getFinancialProduct().getCategory();

        paramCategories.addAll(Arrays.asList(whiteList));

        return paramCategories.contains(dtoCategory);
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
