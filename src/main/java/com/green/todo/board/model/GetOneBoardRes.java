package com.green.todo.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOneBoardRes {
    // board
    @Schema(example = "10", description = "보드 인덱스(PK)")
    private long boardIndex;
    @Schema(example = "오늘 일정 관리", description = "보드 제목")
    private String boardTitle;
    @Schema(example = "1", description = "핀(상단고정)")
    private int pin;
    // item
    @Schema(example = "5", description = "아이템 인덱스(PK)")
    private long itemIndex;
    @Schema(example = "아이템 제목", description = "아이템 제목")
    private String itemTitle;
    @Schema(example = "2", description = "아이템 정렬 순서")
    private int itemPosition;
    // item_contents
    // private String itemContentTitle;
}
