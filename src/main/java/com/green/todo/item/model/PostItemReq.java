package com.green.todo.item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostItemReq {
    @Schema(example = "아이템 제목", description = "아이템 제목")
    private String itemTitle;
    @Schema(example = "10", description = "보드 인덱스(PK)")
    private long boardIndex;
    @JsonIgnore
    private long itemIndex;
}
