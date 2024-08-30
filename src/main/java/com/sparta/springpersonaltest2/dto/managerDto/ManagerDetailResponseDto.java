package com.sparta.springpersonaltest2.dto.managerDto;

import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import lombok.Getter;

@Getter
public class ManagerDetailResponseDto {
    private final Long id;
    private final UserDto user;

    public ManagerDetailResponseDto(Long id, UserDto user) {
        this.id = id;
        this.user = user;
    }
}
