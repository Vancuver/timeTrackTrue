package com.domain.core;

import com.domain.UserEntity;
import com.dto.GetByIDUserResponse;
import com.dto.UserDTO;
import com.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIDService {

    private final UserRepository userRepository;

    public GetUserByIDService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetByIDUserResponse getById(Integer id){
       return userRepository.findById(id)
                .map(this::convert )
                .map(GetByIDUserResponse::new)
               .orElseThrow(() -> new IllegalArgumentException("User with id "+id+" is not found."));
    }

    private UserDTO convert (UserEntity entity){
        return new UserDTO(entity.getId(), entity.getName(), entity.getDescription());
    }
}
