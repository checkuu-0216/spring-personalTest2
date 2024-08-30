package com.sparta.springpersonaltest2.service;

import com.sparta.springpersonaltest2.dto.userDto.UserDetailResponseDto;
import com.sparta.springpersonaltest2.dto.userDto.UserSaveRequestDto;
import com.sparta.springpersonaltest2.dto.userDto.UserSaveResponseDto;
import com.sparta.springpersonaltest2.dto.userDto.UserSimpleResponseDto;
import com.sparta.springpersonaltest2.entity.User;
import com.sparta.springpersonaltest2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto userSaveRequestDto) {
       if(userRepository.existsByEmail(userSaveRequestDto.getEmail())){
           throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
       }

        User user = new User(userSaveRequestDto.getUserName(), userSaveRequestDto.getEmail());

        User savedUser = userRepository.save(user);

        return new UserSaveResponseDto(savedUser.getId(), savedUser.getUserName(), savedUser.getEmail());
    }

    public List<UserSimpleResponseDto> getUsers() {
       List<User> userList = userRepository.findAll();
        List<UserSimpleResponseDto> dtoList = new ArrayList<>();
        for (User user : userList) {
            dtoList.add(new UserSimpleResponseDto(user.getId(),user.getUserName()));
        }
        return dtoList;
    }

    public UserDetailResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("해당 유저가 없습니다."));
        return new UserDetailResponseDto(user.getId(),user.getUserName(),user.getEmail());
    }

    @Transactional
    public void deleteUser(Long userId) {
        if(!userRepository.existsById(userId)){
            throw new NullPointerException("해당하는 유저가 없습니다.");
        }
        userRepository.deleteById(userId);
    }
}
