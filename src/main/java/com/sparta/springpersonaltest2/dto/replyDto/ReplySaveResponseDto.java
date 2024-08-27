package com.sparta.springpersonaltest2.dto.replyDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplySaveResponseDto {

    private final Long id;
    private final String name;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public ReplySaveResponseDto(Long id,String name , String contents,LocalDateTime createAt,LocalDateTime modifiedAt){
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
