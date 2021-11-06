package ru.sniper.projectQuset.entity;

import javax.persistence.*;

@Entity
@Table(name = "quest_table")
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

    public QuestEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(int true_answer) {
        this.trueAnswer = true_answer;
    }
}
