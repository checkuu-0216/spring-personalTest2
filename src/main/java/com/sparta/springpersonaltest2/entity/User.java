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
    @Column(unique = true)
    private String email;

    public User (String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    @OneToMany(mappedBy = "user")
    private List<Manager> managers = new ArrayList<>();

}
