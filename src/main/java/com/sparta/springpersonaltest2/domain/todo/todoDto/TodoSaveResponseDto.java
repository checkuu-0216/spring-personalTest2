package com.sparta.springpersonaltest2.domain.todo.todoDto;

import com.sparta.springpersonaltest2.domain.user.userDto.UserDto;
import com.sparta.springpersonaltest2.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {

    private final Long id;
    private final UserDto user;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public TodoSaveResponseDto(Long id, User user , String title, String contents, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.user= new UserDto(user.getId(), user.getUserName(), user.getEmail());
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
