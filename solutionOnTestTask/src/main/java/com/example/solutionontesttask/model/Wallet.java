package com.example.solutionontesttask.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    private UUID uuid;
    private Long balance;
}
