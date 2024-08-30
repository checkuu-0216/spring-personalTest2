package com.sparta.springpersonaltest2.domain.reply.replyDto;

import com.sparta.springpersonaltest2.domain.user.userDto.UserDto;
import com.sparta.springpersonaltest2.domain.user.User;
import lombok.Getter;

@Getter
public class ReplySimpleResponseDto {
    private final UserDto user;
    private final String contents;

    public ReplySimpleResponseDto(User user , String contents){
        this.user = new UserDto(user.getId(), user.getUserName(), user.getEmail());
        this.contents = contents;
    }
}
