package com.green.todo.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdBoardPinReq {
    @Schema(example = "10", description = "보드 인덱스(PK)")
    private long boardIndex;
    @Schema(example = "1", description = "핀(상단고정)")
    private int pin;
}
