package com.sparta.springpersonaltest2.domain.manager;

import com.sparta.springpersonaltest2.domain.manager.managerDto.ManagerDetailResponseDto;
import com.sparta.springpersonaltest2.domain.manager.managerDto.ManagerSaveRequestDto;
import com.sparta.springpersonaltest2.domain.todo.Todo;
import com.sparta.springpersonaltest2.domain.user.User;
import com.sparta.springpersonaltest2.domain.todo.TodoRepository;
import com.sparta.springpersonaltest2.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Transactional
    public void saveManager(Long todoId, ManagerSaveRequestDto requestDto) {
        //실제로 있는 일정 가져오기
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 일정을 찾을 수 없습니다."));
        //등록하려는 유저가 일정을 만든사람인지 확인하기
        User user = userRepository.findById(requestDto.getTodoUserId()).orElseThrow(() -> new NullPointerException("일정을 만든 유저가 아닙니다."));

        if (!(todo.getUser() != null && ObjectUtils.nullSafeEquals(user.getId(), todo.getUser().getId()))) {
            throw new NullPointerException("등록하려는 유저가 일정을 만든 유저가 아닙니다.");
        }
        //등록하려는 담당자가 실제 존재하는 유저인지 확인.
        User manager = userRepository.findById(requestDto.getManagerUserId()).orElseThrow(() -> new NullPointerException("해당 유저를 찾을 수 없습니다."));

        Manager newManager = new Manager(manager, todo);
        managerRepository.save(newManager);
    }

    public List<ManagerDetailResponseDto> getMenagers(Long todoId) {

        List<Manager> managerList = managerRepository.findByTodoId(todoId);

        List<ManagerDetailResponseDto> dtoList = new ArrayList<>();

        for (Manager manager : managerList) {
            User user = manager.getUser();
            dtoList.add(new ManagerDetailResponseDto(manager.getId(),user.getUserName(),user.getEmail()));
        }
        return dtoList;
    }
}
