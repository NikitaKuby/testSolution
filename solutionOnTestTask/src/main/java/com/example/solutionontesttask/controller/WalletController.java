package com.example.solutionontesttask.controller;

import com.example.solutionontesttask.model.UpdateWalletDto;
import com.example.solutionontesttask.model.Wallet;
import com.example.solutionontesttask.service.WalletService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService service;

    @GetMapping("/{uuid}")
    public Long findByUuid(@PathVariable UUID uuid){
        return service.findBalanceByUuid(uuid);
    }

    @PostMapping
    public String updateWallet(@RequestBody UpdateWalletDto walletDto){
        return service.updateWallet(walletDto);
    }
}
