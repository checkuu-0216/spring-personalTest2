package com.sparta.springpersonaltest2.service;

import com.sparta.springpersonaltest2.dto.todoDto.*;
import com.sparta.springpersonaltest2.entity.Todo;
import com.sparta.springpersonaltest2.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto requestDto) {
        Todo todo = new Todo(requestDto.getUserName(), requestDto.getTitle(), requestDto.getContents());

        Todo savedTodo = todoRepository.save(todo);
        return new TodoSaveResponseDto(
                savedTodo.getId(), savedTodo.getUserName(), savedTodo.getTitle(), savedTodo.getContents(), savedTodo.getCreateAt(), savedTodo.getModifiedAt());

    }

    public TodoDetailResponseDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NullPointerException("해당하는 일정이 없습니다."));
        TodoDetailResponseDto dto = new TodoDetailResponseDto(todo.getId(), todo.getUserName(), todo.getTitle(), todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
        return dto;
    }

    @Transactional
    public TodoUpdateTitleResponseDto updateTodoTitle(Long id, TodoUpdateTitleRequestDto requestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NullPointerException("해당하는 일정이 없습니다."));
        todo.updateTitle(requestDto.getTitle());
        TodoUpdateTitleResponseDto dto = new TodoUpdateTitleResponseDto(todo.getId(), todo.getUserName(), todo.getTitle(), todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
        return dto;
    }

    @Transactional
    public TodoUpdateContentsResponseDto updateTodoContents(Long id, TodoUpdateContentsRequestDto requestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NullPointerException("해당하는 일정이 없습니다."));
        todo.updateContents(requestDto.getContents());
        TodoUpdateContentsResponseDto dto = new TodoUpdateContentsResponseDto(todo.getId(), todo.getUserName(), todo.getTitle(), todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
        return dto;
    }

//    public Page<TodoListResponseDto> getTodoList(Pageable pageable) {
//        List<Todo> todoList = todoRepository.findAll();
//        List<TodoListResponseDto> todoListResponseDtos = new ArrayList<>();
//
//        for (Todo todo : todoList) {
//            todoListResponseDtos.add(new TodoListResponseDto(todo.getUserName(), todo.getTitle(), todo.getContents(),todo.getReply(),todo.getCreateAt(),todo.getModifiedAt()));
//        }
//        return todoListResponseDtos;
//    }

}
