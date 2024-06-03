package com.green.todo.notice;

import com.green.todo.common.model.ResultDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/notice")
public class NoticeController {
    private final NoticeService service;

    @PostMapping
    @Operation(summary = "")
    public ResultDto<Long> p (){

    }
}
