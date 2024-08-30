package com.sparta.springpersonaltest2.domain.user;

import com.sparta.springpersonaltest2.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "\"USER\"")
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;

    @Column(unique = true)
    private String email;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
