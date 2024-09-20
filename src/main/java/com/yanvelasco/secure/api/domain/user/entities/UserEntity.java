package com.yanvelasco.secure.api.domain.user.entities;

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
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private AccountEntity accountEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private CardEntity cardEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FeatureEntity> featureEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NewsEntity> newsEntity;
}