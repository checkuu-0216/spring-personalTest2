package com.sparta.springpersonaltest2.controller;

import com.sparta.springpersonaltest2.dto.*;
import com.sparta.springpersonaltest2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos") //등록
    public TodoSaveResponseDto saveTodo(@RequestBody TodoSaveRequestDto requestDto){
        return todoService.saveTodo(requestDto);
    }

    @GetMapping("/todos/{id}") // 단건조회
    public TodoDetailResponseDto getTodo(@PathVariable Long id){
        return todoService.getTodo(id);
    }

    @PostMapping("/todos/{id}/title") //제목 수정
    public TodoUpdateTitleResponseDto updateTodoTitle(@PathVariable Long id , @RequestBody TodoUpdateTitleRequestDto requestDto){
        return todoService.updateTodoTitle(id,requestDto);
    }

    @PostMapping("/todos/{id}/contents") //내용 수정
    public TodoUpdateContentsResponseDto updateTodoContents(@PathVariable Long id , @RequestBody TodoUpdateContentsRequestDto requestDto){
        return  todoService.updateTodoContents(id,requestDto);
    }
}
