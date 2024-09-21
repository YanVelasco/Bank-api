package com.yanvelasco.secure.api.domain.user.service.imp;

import com.yanvelasco.secure.api.domain.user.entities.UserEntity;
import com.yanvelasco.secure.api.domain.user.repository.UserRepository;
import com.yanvelasco.secure.api.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    @Operation(summary = "Find a user by ID")
    public UserEntity findById(@Parameter(description = "ID of the user to find", example = "123e4567-e89b-12d3-a456-426614174000") UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    @Override
    @Operation(summary = "Create a new user")
    public UserEntity create(@Parameter(description = "User entity to create") UserEntity user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new RuntimeException("User already exists");
        }
        if (userRepository.existsByCardEntityNumber(user.getCardEntity().getNumber())) {
            throw new RuntimeException("Card already exists");
        }
        if (userRepository.existsByAccountEntityNumber(user.getAccountEntity().getNumber())) {
            throw new RuntimeException("Account already exists");
        }
        return userRepository.save(user);
    }

    @Override
    @Operation(summary = "Update an existing user")
    public UserEntity update(@Parameter(description = "ID of the user to update", example = "123e4567-e89b-12d3-a456-426614174000") UUID id,
                             @Parameter(description = "Updated user entity") UserEntity userEntity) {
        var user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        if (userEntity.getName() != null) {
            user.setName(userEntity.getName());
        }

        if (userEntity.getAccountEntity() != null) {
            var account = userEntity.getAccountEntity();

            if (account.getAgency() != null) {
                user.getAccountEntity().setAgency(account.getAgency());
            }
            if (account.getBalance() != null) {
                user.getAccountEntity().setBalance(account.getBalance());
            }
            if (account.getLimit() != null) {
                user.getAccountEntity().setLimit(account.getLimit());
            }
        }

        if (userEntity.getCardEntity() != null) {
            var card = userEntity.getCardEntity();

            if (card.getLimit() != null) {
                user.getCardEntity().setLimit(card.getLimit());
            }

        }

        if (userEntity.getFeatureEntity() != null) {
            user.setFeatureEntity(userEntity.getFeatureEntity());
        }

        if (userEntity.getNewsEntity() != null) {
            user.setNewsEntity(userEntity.getNewsEntity());
        }

        return userRepository.save(user);
    }

    @Override
    @Operation(summary = "Delete a user by ID")
    public void delete(@Parameter(description = "ID of the user to delete", example = "123e4567-e89b-12d3-a456-426614174000") UUID id) {
        var user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        userRepository.delete(user);
    }
}