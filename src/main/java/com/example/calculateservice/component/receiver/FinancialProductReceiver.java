package com.example.calculateservice.component.receiver;

import java.util.*;

import com.example.calculateservice.component.wrapper.ScoredProductDto;
import com.example.calculateservice.swagger.server.model.FinancialProductsParams;

public interface FinancialProductReceiver {

    List<ScoredProductDto> getFinancialProducts(FinancialProductsParams calculatorParams);

}
