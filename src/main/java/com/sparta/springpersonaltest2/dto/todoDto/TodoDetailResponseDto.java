package com.sparta.springpersonaltest2.dto.todoDto;

import com.sparta.springpersonaltest2.dto.replyDto.ReplyDetailResponseDto;
import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import com.sparta.springpersonaltest2.entity.Reply;
import com.sparta.springpersonaltest2.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TodoDetailResponseDto {
    private final Long id;
    private final UserDto user;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public TodoDetailResponseDto (Long id, User user, String title, String contents, LocalDateTime createAt, LocalDateTime modifiedAt){

        this.id = id;
        this.user = new UserDto(user.getId(), user.getUserName(), user.getEmail());
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
