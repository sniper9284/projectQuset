package ru.sniper.projectQuset.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "result")
@Setter
@Getter
@NoArgsConstructor
public class ResultEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "quest_result")
    private String questResult;

    @Column(name = "answer_result")
    private String answerResult;

    @Column(name = "answer_user")
    private String answerUser;

}
