package com.sparta.springpersonaltest2.domain.manager.managerDto;

import lombok.Getter;

@Getter
public class ManagerSaveRequestDto {
    private Long todoUserId; //일정 작성자 유저 id
    private Long managerUserId; // 일정 작성자가 배치하는 유저 id
}
