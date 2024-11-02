package com.example.solutionontesttask.service.Impl;

import com.example.solutionontesttask.dto.UpdateWalletDto;
import com.example.solutionontesttask.model.Wallet;
import com.example.solutionontesttask.repository.WalletRepository;
import com.example.solutionontesttask.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository repository;

    @Override
    public Long findBalanceById(UUID id) {
        return Optional.ofNullable(repository.readById(id)).orElseThrow(() -> new NoSuchElementException("no element")).getBalance();
    }

    @Override
    public void updateWallet(UpdateWalletDto walletDto) {
        if ((walletDto.getOperationType().getTitle().equals(2))
                & findBalanceById(walletDto.getWalletId()) < walletDto.getAmount()) {
            throw new ArithmeticException();
        } else {
            switch (walletDto.getOperationType().getTitle()) {
                case (1):
                    Wallet wallet = new Wallet();
                    wallet.setId(walletDto.getWalletId())
                            .setBalance(findBalanceById(walletDto.getWalletId()) + walletDto.getAmount());
                    repository.save(wallet);
                    break;
                case (2):
                    Wallet wallet2 = new Wallet();
                    wallet2.setId(walletDto.getWalletId())
                            .setBalance(findBalanceById(walletDto.getWalletId()) - walletDto.getAmount());
                    repository.save(wallet2);
                    break;
                default:
            }
        }
    }
}