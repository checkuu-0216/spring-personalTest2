package com.sparta.springpersonaltest2.controller;

import com.sparta.springpersonaltest2.dto.todoDto.*;
import com.sparta.springpersonaltest2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos") //등록
    public TodoSaveResponseDto saveTodo(@RequestBody TodoSaveRequestDto requestDto){
        return todoService.saveTodo(requestDto);
    }

    @GetMapping("/todos/{todoId}") // 단건조회
    public TodoDetailResponseDto getTodo(@PathVariable Long id){

        return todoService.getTodo(id);
    }

    @PutMapping("/todos/{todoId}/title") //제목 수정
    public TodoUpdateTitleResponseDto updateTodoTitle(@PathVariable Long todoId , @RequestBody TodoUpdateTitleRequestDto requestDto){
        return todoService.updateTodoTitle(todoId,requestDto);
    }

    @PutMapping("/todos/{todoId}/contents") //내용 수정
    public TodoUpdateContentsResponseDto updateTodoContents(@PathVariable Long todoId , @RequestBody TodoUpdateContentsRequestDto requestDto){
        return  todoService.updateTodoContents(todoId,requestDto);
    }

    @GetMapping("/todos") //단체 조회
    public ResponseEntity<Page<TodoSimpleResponseDto>> getTodos(@RequestParam(defaultValue = "1",required = false) int page, @RequestParam(defaultValue = "10", required = false) int size) {

        return ResponseEntity.ok(todoService.getTodos(page,size));
    }

    @DeleteMapping("/todos/{todoId}") //일정 삭제
    public void deleteTodo(@PathVariable Long todoId){
        todoService.deleteTodo(todoId);
    }
}
