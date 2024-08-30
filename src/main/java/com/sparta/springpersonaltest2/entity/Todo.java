package com.sparta.springpersonaltest2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;

    @OneToMany(mappedBy = "todo",cascade = CascadeType.REMOVE)
    private List<Reply> Replys = new ArrayList<>();

    @OneToMany(mappedBy = "todo")
    private List<Manager> managers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    public Todo(User user , String title, String contents){
        this.user = user;
        this.title = title;
        this.contents = contents;
    }

    public void updateTitle(String title){
        this.title = title;
    }

    public void updateContents(String contents){
        this.contents = contents;
    }

}
