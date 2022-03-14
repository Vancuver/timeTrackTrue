package Core;

import DataBase.timeTrackRepository;
import Domain.timeTrackEntity;

public class AddUserService {

    private final timeTrackRepository repository; //вписываем зависимость от репозитория

    public AddUserService(timeTrackRepository repository) {
        this.repository = repository;
    }

    public void  addUser(timeTrackEntity entity){
        repository.add(entity);


    }

}
