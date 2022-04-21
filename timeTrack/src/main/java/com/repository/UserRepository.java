package com.repository;

import com.domain.UserEntity;
import com.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    Optional<UserEntity> findById(Integer id);

    List<UserEntity> delete(UserDTO userEntity);
}
