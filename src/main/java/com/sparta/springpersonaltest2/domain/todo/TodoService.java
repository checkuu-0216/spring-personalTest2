package com.sparta.springpersonaltest2.domain.todo;

import com.sparta.springpersonaltest2.domain.reply.ReplyRepository;
import com.sparta.springpersonaltest2.domain.todo.todoDto.*;
import com.sparta.springpersonaltest2.domain.user.User;
import com.sparta.springpersonaltest2.domain.user.UserRepository;
import com.sparta.springpersonaltest2.domain.user.userDto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(()-> new NullPointerException("해당하는 유저가 없습니다."));
        Todo todo = new Todo(user, requestDto.getTitle(), requestDto.getContents());

        Todo savedTodo = todoRepository.save(todo);
        return new TodoSaveResponseDto(savedTodo.getId(),user, savedTodo.getTitle(), savedTodo.getContents(), savedTodo.getCreateAt(), savedTodo.getModifiedAt());
    }

    public TodoDetailResponseDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NullPointerException("해당하는 일정이 없습니다."));
        User user = todo.getUser();
        return new TodoDetailResponseDto(todo.getId(),user, todo.getTitle(), todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
    }

    @Transactional
    public TodoUpdateTitleResponseDto updateTodoTitle(Long id, TodoUpdateTitleRequestDto requestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NullPointerException("해당하는 일정이 없습니다."));
        User user = todo.getUser();
        todo.updateTitle(requestDto.getTitle());
        return new TodoUpdateTitleResponseDto(todo.getId(),new UserDto(user.getId(),user.getUserName(),user.getEmail()), todo.getTitle(), todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
    }

    @Transactional
    public TodoUpdateContentsResponseDto updateTodoContents(Long id, TodoUpdateContentsRequestDto requestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NullPointerException("해당하는 일정이 없습니다."));
        User user = todo.getUser();
        todo.updateContents(requestDto.getContents());
        return new TodoUpdateContentsResponseDto(todo.getId(), new UserDto(user.getId(),user.getUserName(),user.getEmail()), todo.getTitle(), todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
    }

    public Page<TodoSimpleResponseDto> getTodos(int page, int size){
        Pageable pageable = PageRequest.of(page -1,size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new TodoSimpleResponseDto(todo.getId(),todo.getTitle(),todo.getContents(),todo.getCreateAt(),todo.getModifiedAt()));
    }

    @Transactional
    public void deleteTodo(Long todoId){
        if(!todoRepository.existsById(todoId)){
            throw new NullPointerException("해당하는 게시글이 없습니다.");
        }
        todoRepository.deleteById(todoId);
    }
}
