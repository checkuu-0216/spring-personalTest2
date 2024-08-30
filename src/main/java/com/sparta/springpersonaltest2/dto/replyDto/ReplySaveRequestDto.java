package com.sparta.springpersonaltest2.dto.replyDto;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ReplySaveRequestDto {
    private Long userId;
    private String contents;
}
