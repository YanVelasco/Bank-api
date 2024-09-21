package com.yanvelasco.secure.api.domain.user.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Entity representing a credit card")
public class CardEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Setter(AccessLevel.NONE)
    @Schema(description = "Unique identifier of the card", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Column(unique = true)
    @Schema(description = "Unique card number", example = "1234-5678-9012-3456")
    private String number;

    @Column(precision = 13, scale = 2, name = "credit_limit")
    @Schema(description = "Credit limit of the card", example = "5000.00")
    private BigDecimal limit;
}