package com.sparta.springpersonaltest2.domain.todo.todoDto;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {
    private Long userId;
    private String title;
    private String contents;

}
