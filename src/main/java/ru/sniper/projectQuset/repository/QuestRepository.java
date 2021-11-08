package ru.sniper.projectQuset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sniper.projectQuset.entity.QuestEntity;

public interface QuestRepository extends JpaRepository<QuestEntity,Integer> {
}
