package com.domain.core;

import com.dto.UserDTO;
import com.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserService {

    private final UserRepository repository;

    public  DeleteUserService (UserRepository repository) {this.repository = repository;}

    public void delete (UserDTO request){
      repository.delete(request);

    }




}
