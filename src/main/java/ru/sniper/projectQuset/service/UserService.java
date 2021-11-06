package ru.sniper.projectQuset.service;

import ru.sniper.projectQuset.entity.UserEntity;
import java.util.List;

public interface UserService {

    UserEntity getById(int id);
    void saveUser(UserEntity userEntity);
    void updateUser(int id, String login, int ball);
    void deleteUser(UserEntity userEntity);
    List<UserEntity> getAll();

}
