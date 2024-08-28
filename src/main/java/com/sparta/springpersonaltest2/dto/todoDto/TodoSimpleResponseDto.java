package com.sparta.springpersonaltest2.dto.todoDto;

import com.sparta.springpersonaltest2.dto.replyDto.ReplySimpleResponseDto;
import com.sparta.springpersonaltest2.entity.Reply;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TodoSimpleResponseDto {

    private final Long todoId;
    private final String userName;
    private final String title;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;
    private final List<ReplySimpleResponseDto> replys;

    public TodoSimpleResponseDto(Long todoId, String userName, String title,LocalDateTime createAt, LocalDateTime modifiedAt, List<Reply> replys){
        List<ReplySimpleResponseDto> dtoList = new ArrayList<>();
        for (Reply reply : replys) {
            dtoList.add(new ReplySimpleResponseDto(reply.getUserName(),reply.getContents()));
        }
        this.todoId = todoId;
        this.userName = userName;
        this.title = title;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.replys = dtoList;
    }

}
