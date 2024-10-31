package com.example.solutionontesttask.service;

import com.example.solutionontesttask.model.UpdateWalletDto;
import com.example.solutionontesttask.model.Wallet;

import java.util.UUID;

public interface WalletService {
    Long findBalanceByUuid(UUID uuid);

    String updateWallet(UpdateWalletDto walletDto);

}
