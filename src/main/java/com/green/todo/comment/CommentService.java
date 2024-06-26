package com.green.todo.comment;

import com.green.todo.comment.model.req.CommentDeleteReq;
import com.green.todo.comment.model.req.CommentPostReq;
import com.green.todo.comment.model.req.CommentUpdateReq;
import com.green.todo.comment.model.res.CommentGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentMapper mapper;

    public long postComment(CommentPostReq p) {
        if(p.getContent() == null || p.getContent().isEmpty()) {
            throw new RuntimeException("댓글을 입력해주세요.");
        }
        if(mapper.insComment(p) != 1) {
            throw new RuntimeException("댓글을 작성할 수 없습니다.");
        }
        return p.getCommentId();
    }

    public List<CommentGetRes> getCommentList(Long boardId) {
        if(boardId == null || boardId <= 0) {
            throw new RuntimeException("보드의 PK를 입력해주세요.");
        }
        return mapper.getCommentList(boardId);
    }

    public String updateComment(CommentUpdateReq p) {
        CommentGetRes comment = mapper.getCommentOne(p.getCommentId());
        if(comment.getUserId() != p.getSignedUserId()) {
            throw new RuntimeException("댓글 작성자가 다릅니다.");
        }
        if(p.getContent() == null || p.getContent().isEmpty()){
            throw new RuntimeException("댓글을 입력해주세요.");
        }
        mapper.updateComment(p);
        return p.getContent();
    }

    public int deleteComment (CommentDeleteReq p) {
        CommentGetRes comment = mapper.getCommentOne(p.getCommentId());
        if(comment.getUserId() != p.getSignedUserId()) {
            throw new RuntimeException("댓글 작성자가 다릅니다.");
        }
        int result = mapper.deleteComment(p);
        if(result != 1) {
            throw new RuntimeException("댓글을 삭제할 수 없습니다.");
        }
        return result;
    }
}
