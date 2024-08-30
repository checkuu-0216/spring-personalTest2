package com.sparta.springpersonaltest2.domain.reply.replyDto;

import com.sparta.springpersonaltest2.domain.user.userDto.UserDto;
import com.sparta.springpersonaltest2.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyDetailResponseDto {

    private final Long id;
    private final UserDto user;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    public ReplyDetailResponseDto(Long id, User user, String contents, LocalDateTime createAt, LocalDateTime modifiedAt){
        this.id = id;
        this.user = new UserDto(user.getId(),user.getUserName(),user.getEmail());
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
