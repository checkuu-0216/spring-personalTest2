package com.sparta.springpersonaltest2.dto.todoDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSimpleResponseDto {

    private final Long todoId;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public TodoSimpleResponseDto(Long todoId, String title,String contents,LocalDateTime createAt, LocalDateTime modifiedAt){
        this.todoId = todoId;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }

}
