package com.repository;

import com.domain.UserEntity;
import com.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArrayListUserRepository implements UserRepository {

    private List<UserEntity> database = new ArrayList<>();
    private int idSequence = 0;

    @Override
    public UserEntity save(UserEntity userEntity) {
        if(userEntity.getId() != null) {
            return update(userEntity);

        }else {
            userEntity.setId(idSequence);
            idSequence++;
            database.add(userEntity);
        }
        return userEntity;
    }

    private UserEntity update(UserEntity userEntity) {
        for (int i = 0; i < database.size(); i++) {
            var existingEntity = database.get(i);
            if(existingEntity.getId().equals(userEntity.getId())){
                database.set(i, userEntity);
                return userEntity;
            }
        }
        throw new IllegalStateException("Failed to update");
    }

    @Override
    public List<UserEntity> findAll() {
        return database;
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {

        return database.stream().filter(entity -> entity.getId().equals(id))
                .findFirst();

    }

    @Override
    public List<UserEntity> delete(UserDTO userEntity) {
        database.remove(userEntity);
        return null;
    }
}
