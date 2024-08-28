package com.sparta.springpersonaltest2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Reply extends Timestamped{ //todo와 1 대 N 관계

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Todo_id")
    private Todo todo;

    public Reply(String userName, String contents,Todo todo){
       this.userName = userName;
       this.contents =contents;
       this.todo = todo;
    }

    public void updateReply(String contents) {
        this.contents = contents;
    }
}
