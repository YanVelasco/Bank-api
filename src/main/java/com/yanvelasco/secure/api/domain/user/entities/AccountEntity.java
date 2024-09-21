package com.yanvelasco.secure.api.domain.user.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Entity representing a bank account")
public class AccountEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Setter(AccessLevel.NONE)
    @Schema(description = "Unique identifier of the account", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Column(unique = true)
    @Schema(description = "Unique account number", example = "123456789")
    private String number;

    @Schema(description = "Agency of the account", example = "001")
    private String agency;

    @Column(precision = 13, scale = 2)
    @Schema(description = "Current balance of the account", example = "1000.00")
    private BigDecimal balance;

    @Column(precision = 13, scale = 2, name = "credit_limit")
    @Schema(description = "Credit limit of the account", example = "5000.00")
    private BigDecimal limit;
}