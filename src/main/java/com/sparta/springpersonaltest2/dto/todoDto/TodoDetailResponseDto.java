package com.sparta.springpersonaltest2.dto.todoDto;

import com.sparta.springpersonaltest2.dto.replyDto.ReplyDetailResponseDto;
import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import com.sparta.springpersonaltest2.entity.Reply;
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
    private final List<ReplyDetailResponseDto> replys;

    public TodoDetailResponseDto (Long id, UserDto user, String title, String contents, LocalDateTime createAt, LocalDateTime modifiedAt, List<Reply> replys){
        List<ReplyDetailResponseDto> dtoList = new ArrayList<>();
        for (Reply reply : replys) {
            dtoList.add(new ReplyDetailResponseDto(reply.getId(),reply.getUserName(), reply.getContents(), reply.getCreateAt(),reply.getModifiedAt()));
        }

        this.id = id;
        this.user = user;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.replys = dtoList;
    }
}
