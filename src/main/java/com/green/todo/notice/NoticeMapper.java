package com.green.todo.notice;

import com.green.todo.notice.model.req.NoticePostReq;
import com.green.todo.notice.model.res.NoticeGetRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int insertNotice(NoticePostReq p);
    int insertNoticeList();
    List<Long> getCalendarMember(long calendarId);
    List<NoticeGetRes> getNoticeList (long signedUserId);
}
