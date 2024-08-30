package com.sparta.springpersonaltest2.dto.todoDto;

import com.sparta.springpersonaltest2.dto.replyDto.ReplySimpleResponseDto;
import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import com.sparta.springpersonaltest2.entity.Reply;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TodoSimpleResponseDto {

    private final Long todoId;
    private final UserDto user;
    private final String title;
    private final String contents;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;
    private final Integer replyCount;


    public TodoSimpleResponseDto(Long todoId, UserDto user, String title,String contents,List<Reply> replys,LocalDateTime createAt, LocalDateTime modifiedAt){
        List<ReplySimpleResponseDto> dtoList = new ArrayList<>();
        for (Reply reply : replys) {
            dtoList.add(new ReplySimpleResponseDto(reply.getUserName(), reply.getContents()));
        }

        this.todoId = todoId;
        this.user = user;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.replyCount = dtoList.size();
    }

}
