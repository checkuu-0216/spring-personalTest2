package com.sparta.springpersonaltest2.domain.todo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
