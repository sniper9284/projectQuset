package ru.sniper.projectQuset.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "result")
@Getter
@Setter
public class ResultEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "quest_result")
    private String quest_result;

    @Column(name = "answer_result")
    private String answer_result;

    @Column(name = "answer_user")
    private String answer_user;

    public ResultEntity() {
    }

    public ResultEntity(int user_id) {
        this.user_id = user_id;
    }

    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getQuest_result() {
        return quest_result;
    }

    public void setQuest_result(String quest_result) {
        this.quest_result = quest_result;
    }

    public String getAnswer_result() {
        return answer_result;
    }

    public void setAnswer_result(String answer_result) {
        this.answer_result = answer_result;
    }

    public String getAnswer_user() {
        return answer_user;
    }

    public void setAnswer_user(String answer_user) {
        this.answer_user = answer_user;
    }

}
