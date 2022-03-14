package Core;

import DataBase.timeTrackRepository;
import Domain.timeTrackEntity;

import java.util.List;

public class FindAllUsersService { //вписываем зависимость от репозитория

    private final timeTrackRepository repository;

    public FindAllUsersService(timeTrackRepository repository) {
        this.repository = repository;
    }

    public List<timeTrackEntity> findAll(){
        return repository.findAll();
    }
}
