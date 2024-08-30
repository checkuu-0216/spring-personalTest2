package com.sparta.springpersonaltest2.domain.todo.todoDto;

import com.sparta.springpersonaltest2.domain.user.userDto.UserDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateTitleResponseDto {

    private final Long id;
    private final UserDto user;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public TodoUpdateTitleResponseDto (Long id, UserDto user,String title,String contents,LocalDateTime createAt, LocalDateTime modifiedAt){
        this.id = id;
        this.user = user;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
