package com.example.solutionontesttask.model;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateWalletDto {
    private UUID valletId;
    private Long amount;
    private OperationType operationType;
}
