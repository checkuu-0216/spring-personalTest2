package com.sparta.springpersonaltest2.domain.user.userDto;

import lombok.Getter;

@Getter
public class UserDetailResponseDto {

    private final Long id;
    private final String userName;
    private final String email;

    public UserDetailResponseDto (Long id, String userName, String email){
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
