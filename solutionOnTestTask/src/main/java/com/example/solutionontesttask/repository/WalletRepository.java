package com.example.solutionontesttask.repository;

import com.example.solutionontesttask.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    Wallet readById(UUID id);
}
