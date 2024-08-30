package com.sparta.springpersonaltest2.repository;

import com.sparta.springpersonaltest2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

}
