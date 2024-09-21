package com.yanvelasco.secure.api.domain.user.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Entity representing a user")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Setter(AccessLevel.NONE)
    @Schema(description = "Unique identifier of the user", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Name of the user", example = "John Doe")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Schema(description = "Account associated with the user")
    private AccountEntity accountEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @Schema(description = "Card associated with the user")
    private CardEntity cardEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Schema(description = "List of features associated with the user")
    private List<FeatureEntity> featureEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Schema(description = "List of news items associated with the user")
    private List<NewsEntity> newsEntity;
}