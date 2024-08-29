package com.sparta.springpersonaltest2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;

    public User (Long id,String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    @OneToMany(mappedBy = "user")
    private List<UsersTodo> usersTodos = new ArrayList<>();

}
