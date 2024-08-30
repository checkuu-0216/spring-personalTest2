package com.sparta.springpersonaltest2.controller;

import com.sparta.springpersonaltest2.dto.userDto.UserDetailResponseDto;
import com.sparta.springpersonaltest2.dto.userDto.UserSaveRequestDto;
import com.sparta.springpersonaltest2.dto.userDto.UserSaveResponseDto;
import com.sparta.springpersonaltest2.dto.userDto.UserSimpleResponseDto;
import com.sparta.springpersonaltest2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserSaveResponseDto> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return ResponseEntity.ok(userService.saveUser(userSaveRequestDto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleResponseDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDetailResponseDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @DeleteMapping("/users")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
