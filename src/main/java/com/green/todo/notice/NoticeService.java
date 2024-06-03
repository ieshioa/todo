package com.green.todo.notice;

import com.green.todo.notice.model.req.NoticePostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {
    private NoticeMapper mapper;

    public long postNotice(NoticePostReq p) {

    }
}
