package com.yanvelasco.secure.api.domain.user.service;

import com.yanvelasco.secure.api.domain.user.entities.UserEntity;

import java.util.UUID;

public interface UserService {
    UserEntity findById(UUID id);

    UserEntity create(UserEntity user);

    UserEntity update(UUID id,UserEntity user);

    void delete(UUID id);
}
