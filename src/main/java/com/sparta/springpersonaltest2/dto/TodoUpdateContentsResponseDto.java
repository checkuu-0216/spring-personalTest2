package com.sparta.springpersonaltest2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateContentsResponseDto {
    private final Long id;
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public TodoUpdateContentsResponseDto(Long id,String userName,String title, String contents,LocalDateTime createAt,LocalDateTime modifiedAt){
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
