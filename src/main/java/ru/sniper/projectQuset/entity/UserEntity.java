package ru.sniper.projectQuset.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Setter
@Getter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "ball")
    private int ball;

    public UserEntity(String login) {
        this.login = login;
    }
}
