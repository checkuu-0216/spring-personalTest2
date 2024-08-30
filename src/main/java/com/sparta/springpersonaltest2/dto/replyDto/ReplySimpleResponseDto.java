package com.sparta.springpersonaltest2.dto.replyDto;

import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import lombok.Getter;

@Getter
public class ReplySimpleResponseDto {
    private final UserDto user;
    private final String contents;

    public ReplySimpleResponseDto(UserDto user,String contents){
        this.user = user;
        this.contents = contents;
    }
}
