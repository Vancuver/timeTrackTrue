package Core;

import DataBase.timeTrackRepository;
import Domain.timeTrackEntity;

public class AddUserService {

    private final timeTrackRepository repository; //вписываем зависимость от репозитория
    private final ValidationService validationService; //вписываем зависимость от сервиса валидации

    public AddUserService(timeTrackRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public void  addUser(timeTrackEntity entity){
        validationService.validate(entity);
        repository.add(entity);


    }

}
