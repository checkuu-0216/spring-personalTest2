package com.sparta.springpersonaltest2.dto.todoDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateTitleResponseDto {

    private final Long id;
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public TodoUpdateTitleResponseDto (Long id, String userName,String title,String contents,LocalDateTime createAt, LocalDateTime modifiedAt){
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
