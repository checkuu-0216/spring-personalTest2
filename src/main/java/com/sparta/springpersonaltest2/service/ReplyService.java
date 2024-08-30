package com.sparta.springpersonaltest2.service;

import com.sparta.springpersonaltest2.dto.replyDto.*;
import com.sparta.springpersonaltest2.dto.userDto.UserDto;
import com.sparta.springpersonaltest2.entity.Reply;
import com.sparta.springpersonaltest2.entity.Todo;
import com.sparta.springpersonaltest2.entity.User;
import com.sparta.springpersonaltest2.repository.ReplyRepository;
import com.sparta.springpersonaltest2.repository.TodoRepository;
import com.sparta.springpersonaltest2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {
    private final TodoRepository todoRepository;
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;

    @Transactional
    public ReplySaveResponseDto saveReply(@PathVariable Long todoId, ReplySaveRequestDto requestDto) {
        // 일정과 댓글 연관관계 맺어주고 일정에 댓글 달게 메서드 변경
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 게시글이 없습니다."));

        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(()-> new NullPointerException("해당하는 유저가 없습니다."));
        Reply reply = new Reply(user, requestDto.getContents(), todo);
        Reply savedReply = replyRepository.save(reply);
        return new ReplySaveResponseDto(
                savedReply.getId(),
                new UserDto(user.getId(),
                        user.getUserName(),
                        user.getEmail()),
                savedReply.getContents(),
                savedReply.getCreateAt(),
                savedReply.getModifiedAt());
    }

    public ReplyDetailResponseDto getReply(Long replyId) {
        Reply Reply = replyRepository.findById(replyId).orElseThrow(() -> new NullPointerException("해당하는 댓글이 없습니다."));
        User user = Reply.getUser();
        ReplyDetailResponseDto dto = new ReplyDetailResponseDto(Reply.getId(),new UserDto(user.getId(),
                user.getUserName(),
                user.getEmail()),Reply.getContents(), Reply.getCreateAt(), Reply.getModifiedAt());
        return dto;
    }

    @Transactional
    public ReplyUpdateReponseDto updateReply(Long replyId, ReplyUpdateRequestDto requestDto) {
        Reply Reply = replyRepository.findById(replyId).orElseThrow(() -> new NullPointerException("해당하는 댓글이 없습니다."));
        Reply.updateReply(requestDto.getContents());
        ReplyUpdateReponseDto dto = new ReplyUpdateReponseDto(Reply.getId(), Reply.getContents(), Reply.getCreateAt(), Reply.getModifiedAt());
        return dto;
    }


    public List<ReplySimpleResponseDto> getReplys(Long todoId) {
        List<Reply> replies = replyRepository.findByTodoId(todoId);
        List<ReplySimpleResponseDto> replySimpleResponseDtos = new ArrayList<>();
        for (Reply Reply : replies) {
            User user = Reply.getUser();
            replySimpleResponseDtos.add(new ReplySimpleResponseDto(new UserDto(user.getId(),
                    user.getUserName(),
                    user.getEmail()), Reply.getContents()));
        }
        return replySimpleResponseDtos;
    }

    @Transactional
    public void deleteReply(Long replyId) {
        if (!replyRepository.existsById(replyId)) {
            throw new NullPointerException("해당 댓글이 존재하지 않습니다.");
        }
        replyRepository.deleteById(replyId);
    }
}