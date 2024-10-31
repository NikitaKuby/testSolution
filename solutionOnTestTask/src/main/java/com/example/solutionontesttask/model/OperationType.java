package com.example.solutionontesttask.model;

import lombok.Data;
import lombok.Getter;

@Getter
public enum OperationType {
    DEPOSIT("DEPOSIT"),
    WITHDRAW("WITHDRAW");

    private String title;
    OperationType(String title) {
        this.title=title;
    }
}
