package com.sparta.springpersonaltest2.controller;

import com.sparta.springpersonaltest2.dto.replyDto.ReplySimpleResponseDto;
import com.sparta.springpersonaltest2.dto.replyDto.*;
import com.sparta.springpersonaltest2.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/todos/{todoId}/replys") // 해당 게시글에 댓글 저장
    public ReplySaveResponseDto saveReply(@PathVariable Long todoId,@RequestBody ReplySaveRequestDto requestDto) {
        return replyService.saveReply(todoId,requestDto);
    }

    @GetMapping("/todos/{todoId}/replys/{replyId}") //단건조회
    public ReplyDetailResponseDto getReply(@PathVariable Long replyId) {
        return replyService.getReply(replyId);
    }

    @GetMapping("/todos/{todoId}/replys") //단체 조회
    public List<ReplySimpleResponseDto> getReplys(@PathVariable Long todoId) {
        return replyService.getReplys(todoId);
    }

    @PutMapping("/todos/replys/{replyId}") //수정
    public ReplyUpdateReponseDto updateRely(@PathVariable Long replyId, @RequestBody ReplyUpdateRequestDto requestDto){
        return replyService.updateReply(replyId,requestDto);
    }

    @DeleteMapping("/todos/replys/{replyId}") //삭제
    public void deleteReply(@PathVariable Long replyId){
        replyService.deleteReply(replyId);
    }
}
