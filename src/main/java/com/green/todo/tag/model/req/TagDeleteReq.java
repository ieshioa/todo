package com.green.todo.tag.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDeleteReq {
    @Schema(example = "5", description = "로그인된 유저의 PK")
    private Long loginedUserId;
    @Schema(example = "3", description = "삭제할 태그의 PK")
    private Long tagId;
    @Schema(example = "2", description = "태그가 있는 캘린더의 PK")
    private Long calendarId;
}
