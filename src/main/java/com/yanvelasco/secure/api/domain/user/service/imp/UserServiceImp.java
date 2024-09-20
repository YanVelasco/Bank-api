package com.yanvelasco.secure.api.domain.user.service.imp;

import com.yanvelasco.secure.api.domain.user.entities.UserEntity;
import com.yanvelasco.secure.api.domain.user.repository.UserRepository;
import com.yanvelasco.secure.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity findById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    @Override
    public UserEntity create(UserEntity user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public UserEntity update(UUID id, UserEntity userEntity) {
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
    public void delete(UUID id) {
        var user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        userRepository.delete(user);
    }
}