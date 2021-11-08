package ru.sniper.projectQuset.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "quest_table")
@Setter
@Getter
@NoArgsConstructor
public class QuestEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "quest")
    private String quest;

    @Column(name = "answer1")
    private String answer1;

    @Column(name = "answer2")
    private String answer2;

    @Column(name = "answer3")
    private String answer3;

    @Column(name = "answer4")
    private String answer4;

    @Column(name = "true_answer")
    private int trueAnswer;

}
