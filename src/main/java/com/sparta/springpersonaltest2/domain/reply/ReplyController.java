package com.sparta.springpersonaltest2.domain.reply;

import com.sparta.springpersonaltest2.domain.reply.replyDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/todos/{todoId}/replys") // 해당 게시글에 댓글 저장
    public ResponseEntity<ReplySaveResponseDto> saveReply(@PathVariable Long todoId, @RequestBody ReplySaveRequestDto requestDto) {
        return ResponseEntity.ok(replyService.saveReply(todoId,requestDto));
    }

    @GetMapping("/todos/{todoId}/replys/{replyId}") //단건조회
    public ResponseEntity<ReplyDetailResponseDto> getReply(@PathVariable Long replyId) {
        return ResponseEntity.ok(replyService.getReply(replyId));
    }

    @GetMapping("/todos/{todoId}/replys") //단체 조회
    public ResponseEntity<List<ReplySimpleResponseDto>> getReplys(@PathVariable Long todoId) {
        return ResponseEntity.ok(replyService.getReplys(todoId));
    }

    @PutMapping("/todos/replys/{replyId}") //수정
    public ResponseEntity<ReplyUpdateReponseDto> updateRely(@PathVariable Long replyId, @RequestBody ReplyUpdateRequestDto requestDto){
        return ResponseEntity.ok(replyService.updateReply(replyId,requestDto));
    }

    @DeleteMapping("/todos/replys/{replyId}") //삭제
    public void deleteReply(@PathVariable Long replyId){
        replyService.deleteReply(replyId);
    }
}
