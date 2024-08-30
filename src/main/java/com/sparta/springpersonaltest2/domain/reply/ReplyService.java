package com.sparta.springpersonaltest2.domain.reply;

import com.sparta.springpersonaltest2.domain.reply.replyDto.*;
import com.sparta.springpersonaltest2.domain.todo.Todo;
import com.sparta.springpersonaltest2.domain.todo.TodoRepository;
import com.sparta.springpersonaltest2.domain.user.User;
import com.sparta.springpersonaltest2.domain.user.UserRepository;
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
                user,
                savedReply.getContents(),
                savedReply.getCreateAt(),
                savedReply.getModifiedAt());
    }

    public ReplyDetailResponseDto getReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(() -> new NullPointerException("해당하는 댓글이 없습니다."));
        User user = reply.getUser();
        ReplyDetailResponseDto dto = new ReplyDetailResponseDto(reply.getId(),user,reply.getContents(), reply.getCreateAt(), reply.getModifiedAt());
        return dto;
    }

    @Transactional
    public ReplyUpdateReponseDto updateReply(Long replyId, ReplyUpdateRequestDto requestDto) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(() -> new NullPointerException("해당하는 댓글이 없습니다."));
        reply.updateReply(requestDto.getContents());
        ReplyUpdateReponseDto dto = new ReplyUpdateReponseDto(reply.getId(), reply.getContents(), reply.getCreateAt(),reply.getModifiedAt());
        return dto;
    }


    public List<ReplySimpleResponseDto> getReplys(Long todoId) {
        List<Reply> replies = replyRepository.findByTodoId(todoId);
        List<ReplySimpleResponseDto> replySimpleResponseDtos = new ArrayList<>();
        for (Reply reply : replies) {
            User user = reply.getUser();
            replySimpleResponseDtos.add(new ReplySimpleResponseDto(user,reply.getContents()));
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