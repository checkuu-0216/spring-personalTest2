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
    public ResponseEntity<TodoSaveResponseDto> saveTodo(@RequestBody TodoSaveRequestDto requestDto){
        return ResponseEntity.ok(todoService.saveTodo(requestDto));
    }

    @GetMapping("/todos/{todoId}") // 단건조회
    public ResponseEntity<TodoDetailResponseDto> getTodo(@PathVariable Long todoId){
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    @PutMapping("/todos/{todoId}/title") //제목 수정
    public ResponseEntity<TodoUpdateTitleResponseDto> updateTodoTitle(@PathVariable Long todoId , @RequestBody TodoUpdateTitleRequestDto requestDto){
        return ResponseEntity.ok(todoService.updateTodoTitle(todoId,requestDto));
    }

    @PutMapping("/todos/{todoId}/contents") //내용 수정
    public ResponseEntity<TodoUpdateContentsResponseDto> updateTodoContents(@PathVariable Long todoId , @RequestBody TodoUpdateContentsRequestDto requestDto){
        return  ResponseEntity.ok(todoService.updateTodoContents(todoId,requestDto));
    }

    @GetMapping("/todos") //전체 조회
    public ResponseEntity<Page<TodoSimpleResponseDto>> getTodos(
            @RequestParam(defaultValue = "1",required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(todoService.getTodos(page,size));
    }

    @DeleteMapping("/todos/{todoId}") //일정 삭제
    public void deleteTodo(@PathVariable Long todoId){
        todoService.deleteTodo(todoId);
    }
}
