package ru.sniper.projectQuset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sniper.projectQuset.entity.ResultEntity;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Integer> {
}
