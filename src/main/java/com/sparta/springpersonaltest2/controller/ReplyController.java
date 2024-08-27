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

    @PostMapping("/replys") //댓글 저장
    public ReplySaveResponseDto saveReply(@RequestBody ReplySaveRequestDto requestDto) {
        return replyService.saveReply(requestDto);
    }

    @GetMapping("/replys/{replyId}") //단건조회
    public ReplyDetailResponseDto getReply(@PathVariable Long replyId) {
        return replyService.getReply(replyId);
    }

    @GetMapping("/replys") //단체 조회
    public List<ReplySimpleResponseDto> getReplys() {
        return replyService.getReplys();
    }

    @PostMapping("/replys/{replyId}") //수정
    public ReplyUpdateReponseDto updateRely(@PathVariable Long replyId, @RequestBody ReplyUpdateRequestDto requestDto){
        return replyService.updateReply(replyId,requestDto);
    }

    @DeleteMapping("/replys/{replyId}") //삭제
    public void deleteReply(@PathVariable Long replyId){
        replyService.deleteReply(replyId);
    }
}
