package com.sparta.springpersonaltest2.domain.todo;

import com.sparta.springpersonaltest2.domain.reply.Reply;
import com.sparta.springpersonaltest2.entity.Timestamped;
import com.sparta.springpersonaltest2.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "todo",cascade = CascadeType.REMOVE)
    private List<Reply> replys = new ArrayList<>();

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
