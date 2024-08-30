package com.sparta.springpersonaltest2.dto.managerDto;

import lombok.Getter;

@Getter
public class ManagerSaveResponseDto {

    private final Long id;

    public ManagerSaveResponseDto(Long id){
        this.id = id;
    }
}
