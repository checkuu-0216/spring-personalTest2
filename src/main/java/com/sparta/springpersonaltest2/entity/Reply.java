package com.sparta.springpersonaltest2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Reply extends Timestamped{ //todo와 1 대 N 관계

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contents;

    @ManyToOne
    private Todo todo;

    public Reply(String name,String contents){
       this.name = name;
       this.contents =contents;
    }

    public void updateReply(String contents) {
        this.contents = contents;
    }
}
