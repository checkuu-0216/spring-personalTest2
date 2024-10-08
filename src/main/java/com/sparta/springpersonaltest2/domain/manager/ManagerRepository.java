package com.sparta.springpersonaltest2.domain.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    List<Manager> findByTodoId(Long todoId);
}
