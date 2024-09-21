package com.yanvelasco.secure.api.domain.user.service;

import com.yanvelasco.secure.api.domain.user.entities.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.UUID;

public interface UserService {

    @Operation(summary = "Find a user by ID")
    UserEntity findById(@Parameter(description = "ID of the user to find", example = "123e4567-e89b-12d3-a456-426614174000") UUID id);

    @Operation(summary = "Create a new user")
    UserEntity create(@Parameter(description = "User entity to create") UserEntity user);

    @Operation(summary = "Update an existing user")
    UserEntity update(@Parameter(description = "ID of the user to update", example = "123e4567-e89b-12d3-a456-426614174000") UUID id,
                      @Parameter(description = "Updated user entity") UserEntity user);

    @Operation(summary = "Delete a user by ID")
    void delete(@Parameter(description = "ID of the user to delete", example = "123e4567-e89b-12d3-a456-426614174000") UUID id);
}