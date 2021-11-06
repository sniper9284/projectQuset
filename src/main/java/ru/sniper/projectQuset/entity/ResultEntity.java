package ru.sniper.projectQuset.entity;

import javax.persistence.*;

@Entity
@Table(name = "result")
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

    public ResultEntity() {
    }

    public ResultEntity(int user_id) {
        this.userId = user_id;
    }

    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public String getQuestResult() {
        return questResult;
    }

    public void setQuestResult(String quest_result) {
        this.questResult = quest_result;
    }

    public String getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(String answer_result) {
        this.answerResult = answer_result;
    }

    public String getAnswerUser() {
        return answerUser;
    }

    public void setAnswerUser(String answer_user) {
        this.answerUser = answer_user;
    }

}
