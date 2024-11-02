package com.example.solutionontesttask.dto;

import com.example.solutionontesttask.model.OperationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UpdateWalletDto {

    @NotNull
    private UUID walletId;
    @NotNull
    @Min(0)
    private Double amount;
    @NotNull
    private OperationType operationType;

    public Long getAmount() {

        return (long) (amount*100);
    }
}
