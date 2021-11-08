package ru.sniper.projectQuset.repository.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sniper.projectQuset.entity.UserEntity;
import ru.sniper.projectQuset.repository.UserRepository;
import ru.sniper.projectQuset.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void updateUser(int id, String login, int ball) {
        UserEntity updateUser = userRepository.getById(id);
        updateUser.setLogin(login);
        updateUser.setBall(ball);
        userRepository.save(updateUser);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

}
