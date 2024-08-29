package com.sparta.springpersonaltest2.dto.replyDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyUpdateReponseDto {

    private final Long id;

    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public ReplyUpdateReponseDto(Long id, String contents,LocalDateTime createAt,LocalDateTime modifiedAt){
        this.id = id;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
