package com.sparta.springpersonaltest2.domain.manager;

import com.sparta.springpersonaltest2.domain.todo.Todo;
import com.sparta.springpersonaltest2.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Manager{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false) //일정 만든사람 id
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id",nullable = false) //일정 id
    private Todo todo;

    public Manager(User user, Todo todo) {
        this.user = user;
        this.todo = todo;
    }
}
