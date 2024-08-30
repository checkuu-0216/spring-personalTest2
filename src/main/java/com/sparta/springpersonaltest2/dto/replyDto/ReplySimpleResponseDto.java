package com.sparta.springpersonaltest2.dto.replyDto;

import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import com.sparta.springpersonaltest2.entity.User;
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
