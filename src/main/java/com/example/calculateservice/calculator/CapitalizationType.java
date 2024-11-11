package com.example.calculateservice.calculator;

import java.util.*;

public enum CapitalizationType {
    SIMPLE(false, ""),
    DAILY(true, "Ежедневно"),
    MONTHLY(true, "Ежемесячно"),
    QUARTERLY(true, "Ежеквартально"),
    YEARLY(true, "Ежегодно");

    private Boolean capitalization;

    private String period;

    CapitalizationType(Boolean capitalization, String period) {
        this.capitalization = capitalization;
        this.period = period;
    }

    public static CapitalizationType getType(Boolean capitalization, String period) {
        var listTypes = Arrays.stream(values())
                .filter(capitalizationType -> capitalizationType.capitalization == capitalization)
                .toList();
        if (listTypes.size() == 1) {
            return listTypes.get(0);
        }
        return listTypes.stream()
                .filter(capitalizationType -> capitalizationType.period.equals(period))
                .findFirst()
                .orElseThrow();

    }
}

