package com.green.todo.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostBoardReq {
    @Schema(example = "오늘 일정 관리", description = "보드 제목")
    private String boardTitle;
    @JsonIgnore
    private long boardIndex;
}
