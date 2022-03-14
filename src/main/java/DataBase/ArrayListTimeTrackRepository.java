package DataBase;

import Domain.timeTrackEntity;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTimeTrackRepository implements timeTrackRepository{ //На данный момент репозиторий это список

    private List<timeTrackEntity> database = new ArrayList<>(); //создаём базу данных для проекта
    private int idSequence = 0; //начинаем отсчёт действий в меню

    @Override
    public timeTrackEntity add(timeTrackEntity timeTrackEntity) { //реализация метода add
        timeTrackEntity.setId(idSequence);
        idSequence++;
        database.add(timeTrackEntity);
        return timeTrackEntity;

    }

    @Override
    public List<timeTrackEntity> findAll() { //реализация метода findAll
        return database;
    }
}
