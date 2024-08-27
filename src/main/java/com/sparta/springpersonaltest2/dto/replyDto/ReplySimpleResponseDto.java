package com.sparta.springpersonaltest2.dto.replyDto;

import lombok.Getter;

@Getter
public class ReplySimpleResponseDto {
    private final String name;
    private final String contents;

    public ReplySimpleResponseDto(String name,String contents){
        this.name = name;
        this.contents = contents;
    }
}
