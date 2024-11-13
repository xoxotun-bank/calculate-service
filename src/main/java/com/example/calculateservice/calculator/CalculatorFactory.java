package com.example.calculateservice.calculator;

import java.util.*;
import java.util.stream.*;

import org.springframework.stereotype.*;

@Component
public class CalculatorFactory {

    private final Map<CapitalizationType, AbstractCalculator> calculatorMap;

    public CalculatorFactory(List<AbstractCalculator> calculators) {
        this.calculatorMap = calculators.stream()
                .collect(Collectors.toMap(AbstractCalculator::getType, calculator -> calculator));
    }

    public AbstractCalculator getCalculator(boolean isCapitalization, String type) {
        CapitalizationType capitalizationType = CapitalizationType.getType(isCapitalization, type);
        return calculatorMap.get(capitalizationType);
    }

}
