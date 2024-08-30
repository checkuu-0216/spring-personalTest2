package com.sparta.springpersonaltest2.dto.replyDto;

import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplySaveResponseDto {

    private final Long todoId;
    private final UserDto user;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public ReplySaveResponseDto(Long todoId,UserDto user , String contents,LocalDateTime createAt,LocalDateTime modifiedAt){
        this.todoId = todoId;
        this.user = user;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
