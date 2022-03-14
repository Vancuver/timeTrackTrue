package DataBase;

import Domain.timeTrackEntity;

import java.util.List;

public interface timeTrackRepository { //Интерфейс потому что реализации могут быть разные(инфа с сайта, с
    // другого файла и т.д.
    timeTrackEntity add(timeTrackEntity timeTrackEntity); //у всех репозиториев должна быть возможность добавить юзера

    List<timeTrackEntity> findAll();//у всех репозиториев должна быть возможность показать всех юзеров
}
