package com.example.solutionontesttask.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    private UUID id;
    private Long balance;
}
