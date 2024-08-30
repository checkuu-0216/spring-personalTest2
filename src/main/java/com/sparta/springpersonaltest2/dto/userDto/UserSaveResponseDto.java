package com.sparta.springpersonaltest2.dto.userDto;

import lombok.Getter;

@Getter
public class UserSaveResponseDto {

    private final Long id;
    private final String userName;
    private final String email;

    public UserSaveResponseDto (Long id, String userName, String email){
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
