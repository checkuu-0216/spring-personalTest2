package com.sparta.springpersonaltest2.repository;

import com.sparta.springpersonaltest2.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
}
