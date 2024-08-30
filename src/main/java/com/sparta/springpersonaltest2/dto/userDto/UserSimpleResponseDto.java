package com.sparta.springpersonaltest2.dto.userDto;

import lombok.Getter;

@Getter
public class UserSimpleResponseDto {

    private final Long id;
    private final String userName;

    public UserSimpleResponseDto(Long id, String userName){
        this.id = id;
        this.userName = userName;
    }
}
