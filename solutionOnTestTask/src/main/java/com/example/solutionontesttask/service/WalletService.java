package com.example.solutionontesttask.service;

import com.example.solutionontesttask.dto.UpdateWalletDto;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletService {
    Long findBalanceById(UUID uuid);

    void updateWallet(UpdateWalletDto walletDto);

}
