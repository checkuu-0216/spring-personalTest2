package com.sparta.springpersonaltest2.repository;

import com.sparta.springpersonaltest2.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
    List<Reply> findByTodoId(Long id);
}
