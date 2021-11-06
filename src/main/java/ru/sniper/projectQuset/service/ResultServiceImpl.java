package ru.sniper.projectQuset.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sniper.projectQuset.entity.ResultEntity;
import ru.sniper.projectQuset.repository.ResultRepository;
import java.util.List;

@Transactional
@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;

    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }


    @Override
    public ResultEntity getById(int id) {
        return resultRepository.getById(id);
    }

    @Override
    public void saveResult(ResultEntity resultEntity) {
        resultRepository.save(resultEntity);
    }

    @Override
    public void updateResult(int id, int user_id, String quest_result, String answer_result, String answer_user) {
        ResultEntity updateResult = resultRepository.getById(id);
        updateResult.setUser_id(user_id);
        updateResult.setQuest_result(quest_result);
        updateResult.setAnswer_result(answer_result);
        updateResult.setAnswer_user(answer_user);
        resultRepository.save(updateResult);
    }


    @Override
    public void deleteResult(ResultEntity resultEntity) {
        resultRepository.delete(resultEntity);
    }

    @Override
    public List<ResultEntity> getAll() {
        return resultRepository.findAll();
    }
}
