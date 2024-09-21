package com.yanvelasco.secure.api.domain.user.repository;

import com.yanvelasco.secure.api.domain.user.entities.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Operation(summary = "Check if a user exists by card number")
    boolean existsByCardEntityNumber(@Parameter(description = "Card number to check", example = "1234-5678-9012-3456") String number);

    @Operation(summary = "Check if a user exists by account number")
    boolean existsByAccountEntityNumber(@Parameter(description = "Account number to check", example = "1234567890") String number);
}