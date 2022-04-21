package com.domain.core;

import com.domain.UserEntity;
import com.dto.UpdateUserRequest;
import com.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserService {

    private final UserRepository repository;

    public  UpdateUserService (UserRepository repository) {this.repository = repository;}

    public void update (UpdateUserRequest request){
        repository.findById(request.getId())
                .map(entity -> updateFields(entity, request))
                .ifPresent(repository::save);
    }

    private UserEntity updateFields( UserEntity entity, UpdateUserRequest request) {
        var updatedEntity = new UserEntity();
        updatedEntity.setId(entity.getId());
        updatedEntity.setDescription(entity.getDescription());
        updatedEntity.setName(request.getName());
        return updatedEntity;
    }
}
