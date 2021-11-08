package ru.sniper.projectQuset.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sniper.projectQuset.entity.ResultEntity;
import ru.sniper.projectQuset.repository.ResultRepository;
import ru.sniper.projectQuset.service.ResultService;
import java.util.List;

@Service
@Transactional(readOnly = true)
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
        updateResult.setUserId(user_id);
        updateResult.setQuestResult(quest_result);
        updateResult.setAnswerResult(answer_result);
        updateResult.setAnswerUser(answer_user);
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
