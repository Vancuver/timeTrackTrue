package Core;

import Core.Validation.ValidationService;
import DataBase.timeTrackRepository;
import Domain.timeTrackEntity;
import dto.AddUserRequest;
import dto.AddUserResponse;

import java.util.List;

public class AddUserService {

    private final timeTrackRepository repository; //вписываем зависимость от репозитория
    private final ValidationService validationService; //вписываем зависимость от сервиса валидации

    public AddUserService(timeTrackRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddUserResponse addUser(AddUserRequest request){

        var entity = convert(request);

        var validationResult = validationService.validate(request);

        if (!validationResult.isEmpty()){
            var response = new AddUserResponse();
            response.setErrors(validationResult);
            return response;
        }


        var createdEntity =  repository.add(entity);

        var response = new AddUserResponse();
        response.setCreatedID(createdEntity.getId());
        return response;

    }

    private timeTrackEntity convert(AddUserRequest request){
        timeTrackEntity entity = new timeTrackEntity();
        entity.setName(request.getName());
        entity.setSurname(request.getSurname());
        return entity;
    }
}
