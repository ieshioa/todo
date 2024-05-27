package com.green.todo.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdBoardTitleReq {
    @Schema(example = "10", description = "보드 인덱스(PK)")
    private long boardIndex;
    @Schema(example = "오늘 일정 관리", description = "보드 제목")
    private String boardTitle;
}
