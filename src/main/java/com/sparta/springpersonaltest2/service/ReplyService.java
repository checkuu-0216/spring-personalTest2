package com.sparta.springpersonaltest2.service;

import com.sparta.springpersonaltest2.dto.replyDto.*;
import com.sparta.springpersonaltest2.entity.Reply;
import com.sparta.springpersonaltest2.entity.Todo;
import com.sparta.springpersonaltest2.repository.ReplyRepository;
import com.sparta.springpersonaltest2.repository.TodoRepository;
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

    @Transactional
    public ReplySaveResponseDto saveReply(@PathVariable Long todoId, ReplySaveRequestDto requestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 게시글이 없습니다."));

        Reply reply = new Reply(requestDto.getUserName(),requestDto.getContents(),todo);
        Reply savedReply =  replyRepository.save(reply);
        return new ReplySaveResponseDto(savedReply.getId(), savedReply.getUserName(), savedReply.getContents(), savedReply.getCreateAt(), savedReply.getModifiedAt());
    }

    public ReplyDetailResponseDto getReply(Long replyId) {
        Reply Reply = replyRepository.findById(replyId).orElseThrow(()-> new NullPointerException("해당하는 댓글이 없습니다."));
        ReplyDetailResponseDto dto = new ReplyDetailResponseDto(Reply.getId(), Reply.getUserName(), Reply.getContents(), Reply.getCreateAt(), Reply.getModifiedAt());
        return dto;
    }

    @Transactional
    public ReplyUpdateReponseDto updateReply(Long replyId, ReplyUpdateRequestDto requestDto) {
        Reply Reply = replyRepository.findById(replyId).orElseThrow(()-> new NullPointerException("해당하는 댓글이 없습니다."));
        Reply.updateReply(requestDto.getContents());
        ReplyUpdateReponseDto dto = new ReplyUpdateReponseDto(Reply.getId(), Reply.getUserName(), Reply.getContents(), Reply.getCreateAt(), Reply.getModifiedAt());
        return dto;
    }


    public List<ReplySimpleResponseDto> getReplys() {
        List<Reply> replies = replyRepository.findAll();
        List<ReplySimpleResponseDto> replySimpleResponseDtos = new ArrayList<>();
        for (Reply Reply : replies) {
            replySimpleResponseDtos.add(new ReplySimpleResponseDto(Reply.getUserName(), Reply.getContents()));
        }
        return replySimpleResponseDtos;
    }


    public void deleteReply(Long replyId) {
        Reply Reply = replyRepository.findById(replyId).orElseThrow(()-> new NullPointerException("해당하는 댓글이 없습니다."));
        replyRepository.delete(Reply);
    }
}
