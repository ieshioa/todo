package com.green.todo.tag.model.req;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class TagUpdateReq {
    @Schema(example = "프로젝트", description = "태그 이름")
    private String title;
    @Schema(example = "1", description = "태그 색상")
    private Integer color;
    @Schema(example = "3", description = "수정할 태그의 PK")
    private Long tagId;
}
