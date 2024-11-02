package com.example.solutionontesttask.controller;

import com.example.solutionontesttask.dto.UpdateWalletDto;
import com.example.solutionontesttask.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService service;

    @GetMapping("/{id}")
    public ResponseEntity<Double> findByUuid(@PathVariable UUID id) {
        return new ResponseEntity<>(((double)service.findBalanceById(id))/100,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> updateWallet(@Valid @RequestBody UpdateWalletDto walletDto){
        service.updateWallet(walletDto);
        return new ResponseEntity<>("Successful",HttpStatus.OK);
    }
}
