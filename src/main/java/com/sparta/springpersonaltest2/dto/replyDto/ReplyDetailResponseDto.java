package com.sparta.springpersonaltest2.dto.replyDto;

import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyDetailResponseDto {

    private final Long id;
    private final UserDto user;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public ReplyDetailResponseDto(Long id,UserDto user, String contents,LocalDateTime createAt,LocalDateTime modifiedAt){
        this.id = id;
        this.user = user;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
