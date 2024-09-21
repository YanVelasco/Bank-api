package com.yanvelasco.secure.api.domain.user.controller;

import com.yanvelasco.secure.api.domain.user.entities.UserEntity;
import com.yanvelasco.secure.api.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Create a new user")
    public ResponseEntity<UserEntity> create(@RequestBody @Parameter(description = "User entity to create") UserEntity user) {
        var userEntity = userService.create(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(userEntity);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a user by ID")
    public ResponseEntity<UserEntity> findById(@PathVariable @Parameter(description = "ID of the user to find", example = "123e4567-e89b-12d3-a456-426614174000") UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing user")
    public ResponseEntity<UserEntity> update(@PathVariable @Parameter(description = "ID of the user to update", example = "123e4567-e89b-12d3-a456-426614174000") UUID id,
                                             @RequestBody @Parameter(description = "Updated user entity") UserEntity user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user by ID")
    public ResponseEntity<Void> delete(@PathVariable @Parameter(description = "ID of the user to delete", example = "123e4567-e89b-12d3-a456-426614174000") UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}