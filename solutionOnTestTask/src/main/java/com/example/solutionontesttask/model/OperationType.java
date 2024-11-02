package com.example.solutionontesttask.model;

import lombok.Getter;

@Getter
public enum OperationType {
    DEPOSIT(1),
    WITHDRAW(2);

    final private Integer title;
    OperationType(Integer title) {
        this.title=title;
    }
}
