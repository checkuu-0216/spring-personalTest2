package com.sparta.springpersonaltest2.controller;

import com.sparta.springpersonaltest2.dto.managerDto.ManagerDetailResponseDto;
import com.sparta.springpersonaltest2.dto.managerDto.ManagerSaveRequestDto;
import com.sparta.springpersonaltest2.dto.managerDto.ManagerSaveResponseDto;
import com.sparta.springpersonaltest2.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    public final ManagerService managerService;

    @PostMapping("/todos/{todoId}/managers")
    public void saveManager(@PathVariable Long todoId,@RequestBody ManagerSaveRequestDto requestDto) {
        managerService.saveManager(todoId, requestDto);
    }

    @GetMapping("/todos/{todoId}/managers")
    public ResponseEntity<List<ManagerDetailResponseDto>> getManagers(@PathVariable Long todoId){
        return ResponseEntity.ok(managerService.getMenagers(todoId));
    }

//    @DeleteMapping("/todos/{todoId}/managers/{managerId}")

}
