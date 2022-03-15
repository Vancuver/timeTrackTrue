package Core;

import Domain.timeTrackEntity;

public class ValidationService {

    public void  validate (timeTrackEntity timeTrackEntity){
        if (timeTrackEntity == null){
            throw  new ValidationException("Name and surname must not be null");
        }
        if (timeTrackEntity.getName() == null){
            throw  new ValidationException("User name must not be null");
        }
        if (timeTrackEntity.getSurname() == null){
            throw  new ValidationException("User surname must not be null");
        }
        if (timeTrackEntity.getName().length()> 12){
            throw new ValidationException("Name need to be less than 12 symbols");
        }
        if (timeTrackEntity.getSurname().length()> 12){
            throw new ValidationException("Surname need to be less than 12 symbols");
        }
        if (timeTrackEntity.getName().length()< 3){
            throw new ValidationException("Name need to be more than 3 symbols");
        }
        if (timeTrackEntity.getSurname().length()< 3){
            throw new ValidationException("Surname need to be more than 3 symbols");
        }
    }

}
