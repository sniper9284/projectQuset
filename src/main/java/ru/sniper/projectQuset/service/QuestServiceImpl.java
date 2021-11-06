package ru.sniper.projectQuset.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sniper.projectQuset.entity.QuestEntity;
import ru.sniper.projectQuset.repository.QuestRepository;
import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    private final QuestRepository questRepository;

    public QuestServiceImpl(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    @Transactional
    @Override
    public QuestEntity getById(int id) {
        return questRepository.getById(id);
    }
    @Transactional
    @Override
    public void saveQuest(QuestEntity questEntity) {
        questRepository.save(questEntity);
    }
    @Transactional
    @Override
    public void updateQuest(int id, String quest, String answer1, String answer2, String answer3, String answer4, int true_answer) {
        QuestEntity updateQuest = questRepository.getById(id);
        updateQuest.setQuest(quest);
        updateQuest.setAnswer1(answer1);
        updateQuest.setAnswer2(answer2);
        updateQuest.setAnswer3(answer3);
        updateQuest.setAnswer4(answer4);
        updateQuest.setTrue_answer(true_answer);
        questRepository.save(updateQuest);
    }
    @Transactional
    @Override
    public void deleteQuest(QuestEntity questEntity) {
        questRepository.delete(questEntity);
    }
    @Transactional
    @Override
    public List<QuestEntity> getAll() {
        return questRepository.findAll();
    }
}
