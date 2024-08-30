package com.sparta.springpersonaltest2.domain.reply;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
    List<Reply> findByTodoId(Long todoId);
}
