package com.sparta.springpersonaltest2.repository;

import com.sparta.springpersonaltest2.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    List<Manager> findByTodoId();
}
