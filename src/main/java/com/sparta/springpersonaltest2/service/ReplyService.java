package com.sparta.springpersonaltest2.service;

import com.sparta.springpersonaltest2.dto.replyDto.*;
import com.sparta.springpersonaltest2.entity.Reply;
import com.sparta.springpersonaltest2.repository.ReplyRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional
    public ReplySaveResponseDto saveReply(ReplySaveRequestDto requestDto) {
        Reply reply = new Reply(requestDto.getName(),requestDto.getContents());
        Reply savedReply =  replyRepository.save(reply);
        return new ReplySaveResponseDto(savedReply.getId(),savedReply.getName(),savedReply.getContents(),savedReply.getCreateAt(),savedReply.getModifiedAt());
    }

    public ReplyDetailResponseDto getReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(()-> new NullPointerException("해당하는 댓글이 없습니다."));
        ReplyDetailResponseDto dto = new ReplyDetailResponseDto(reply.getId(),reply.getName(),reply.getContents(),reply.getCreateAt(),reply.getModifiedAt());
        return dto;
    }

    @Transactional
    public ReplyUpdateReponseDto updateReply(Long replyId, ReplyUpdateRequestDto requestDto) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(()-> new NullPointerException("해당하는 댓글이 없습니다."));
        reply.updateReply(requestDto.getContents());
        ReplyUpdateReponseDto dto = new ReplyUpdateReponseDto(reply.getId(),reply.getName(),reply.getContents(),reply.getCreateAt(),reply.getModifiedAt());
        return dto;
    }


    public List<ReplySimpleResponseDto> getReplys() {
        List<Reply> replies = replyRepository.findAll();
        List<ReplySimpleResponseDto> replySimpleResponseDtos = new ArrayList<>();
        for (Reply reply : replies) {
            replySimpleResponseDtos.add(new ReplySimpleResponseDto(reply.getName(), reply.getContents()));
        }
        return replySimpleResponseDtos;
    }


    public void deleteReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(()-> new NullPointerException("해당하는 댓글이 없습니다."));
        replyRepository.delete(reply);
    }
}
