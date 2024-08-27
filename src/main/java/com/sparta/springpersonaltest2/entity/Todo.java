package com.sparta.springpersonaltest2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String title;
    private String contents;

    @OneToMany
    private List<Reply> reply = new ArrayList<>();


    public Todo(String userName , String title, String contents){
        this.userName = userName;
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
