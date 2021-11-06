package ru.sniper.projectQuset.service;

import ru.sniper.projectQuset.entity.QuestEntity;

import java.util.List;

public interface QuestService {
    QuestEntity getById(int id);
    void saveQuest(QuestEntity questEntity);
    void updateQuest(int id, String quest, String answer1, String answer2, String answer3, String answer4, int true_answer);
    void deleteQuest(QuestEntity questEntity);
    List<QuestEntity> getAll();
}
