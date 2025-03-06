package com.example.calculateservice.component.predicate;

import lombok.*;

@Getter
public enum CurrentField {
    PERIOD("period"),
    CAN_DEPOSIT("canDeposit"),
    CAN_WITHDRAWAL("canWithdrawal"),
    CAPITALIZATION_TO_SAME_ACCOUNT("capitalizationToSameAccount"),
    CAPITALIZATION_PERIOD("capitalizationPeriod"),
    REQUIRED("required");

    private final String name;

    CurrentField(String name) {
        this.name = name;
    }

}