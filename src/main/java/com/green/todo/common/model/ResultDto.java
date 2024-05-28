package com.green.todo.common.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResultDto<T> {
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;

    public static <T> ResultDto<T> resultDto(HttpStatus status, String msg, T data) {
        return ResultDto.<T>builder()
                .statusCode(status)
                .resultMsg(msg)
                .resultData(data)
                .build();
    }

}
