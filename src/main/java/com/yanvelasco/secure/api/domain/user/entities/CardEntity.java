package com.yanvelasco.secure.api.domain.user.entities;

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
public class CardEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(unique = true)
    private String number;

    @Column(precision = 13, scale = 2, name = "credit_limit")
    private BigDecimal limit;
}