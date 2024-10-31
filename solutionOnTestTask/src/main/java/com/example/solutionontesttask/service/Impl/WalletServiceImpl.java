package com.example.solutionontesttask.service.Impl;

import com.example.solutionontesttask.model.UpdateWalletDto;
import com.example.solutionontesttask.model.Wallet;
import com.example.solutionontesttask.repository.WalletRepository;
import com.example.solutionontesttask.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository repository;

    public Long findBalanceByUuid(UUID uuid) {
        return repository.findWalletByUuid(uuid).getBalance();
    }

    public String updateWallet(UpdateWalletDto walletDto) {
        if ((walletDto.getOperationType().getTitle().equals("WITHDRAW"))
                & findBalanceByUuid(walletDto.getValletId()) < walletDto.getAmount() ){
            return "Not enough funds";

        }
        if (walletDto.getOperationType().getTitle().equals("WITHDRAW")){
            Wallet wallet=new Wallet();
            wallet.setUuid(walletDto.getValletId());
            wallet.setBalance(findBalanceByUuid(walletDto.getValletId())- walletDto.getAmount());
            repository.save(wallet);
        }else {
            Wallet wallet=new Wallet();
            wallet.setUuid(walletDto.getValletId());
            wallet.setBalance(findBalanceByUuid(walletDto.getValletId()) + walletDto.getAmount());
            repository.save(wallet);
        }
        return "Operation completed";
    }
}
