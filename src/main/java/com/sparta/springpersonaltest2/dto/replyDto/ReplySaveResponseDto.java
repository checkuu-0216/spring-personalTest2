package com.sparta.springpersonaltest2.dto.replyDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplySaveResponseDto {

    private final Long todoId;
    private final String name;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public ReplySaveResponseDto(Long todoId,String name , String contents,LocalDateTime createAt,LocalDateTime modifiedAt){
        this.todoId = todoId;
        this.name = name;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
