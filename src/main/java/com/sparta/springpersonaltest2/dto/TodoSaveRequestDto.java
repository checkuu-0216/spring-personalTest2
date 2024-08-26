package com.sparta.springpersonaltest2.dto;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {
    private String userName;
    private String title;
    private String contents;

}
