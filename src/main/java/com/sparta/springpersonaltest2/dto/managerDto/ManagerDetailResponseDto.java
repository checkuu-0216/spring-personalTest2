package com.sparta.springpersonaltest2.dto.managerDto;

import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import lombok.Getter;

@Getter
public class ManagerDetailResponseDto {
    private final Long id;
    private final String userName;
    private final String email;

    public ManagerDetailResponseDto(Long id, String userName,String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
