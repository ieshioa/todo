package com.green.todo.tag;

import com.green.todo.tag.model.TagEntity;
import com.green.todo.tag.model.req.TagDeleteReq;
import com.green.todo.tag.model.req.TagPostReq;
import com.green.todo.tag.model.req.TagUpdateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagMapper mapper;

    public long tagPost (TagPostReq p) {
        if(p.getTitle() == null || p.getTitle().isEmpty()) {
            throw new RuntimeException("태그 이름을 입력해주세요.");
        }
        TagEntity tag = mapper.getTagByTitle(p.getTitle());
        if(tag != null) {
            throw new RuntimeException("이미 있는 태그입니다.");
        }
        mapper.insertTag(p);
        return p.getTagId();
    }

    public int updateTag(TagUpdateReq p) {
        if((p.getTitle() == null || p.getTitle().isEmpty()) && p.getColor() < 0 ) {
            throw new RuntimeException("수정할 내용을 입력해주세요.");
        }
        TagEntity tag = mapper.getTagByTitle(p.getTitle());
        if(tag != null && p.getTagId() != tag.getTagId()) {
            throw new RuntimeException("이미 있는 태그입니다.");
        }
        return mapper.updateTag(p);
    }

    public int deleteTag(TagDeleteReq p) {
        int result = mapper.deleteTag(p);
        if (result != 1) {
            throw new RuntimeException("삭제할 수 없습니다.");
        }
        return result;
    }


}
