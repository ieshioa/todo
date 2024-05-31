package com.green.todo.tag;

import com.green.todo.tag.model.TagEntity;
import com.green.todo.tag.model.req.TagDeleteReq;
import com.green.todo.tag.model.req.TagPostReq;
import com.green.todo.tag.model.req.TagUpdateReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    int insertTag(TagPostReq p);
    TagEntity getTagByTitle(String title);
    int updateTag(TagUpdateReq p);
    int deleteTag(TagDeleteReq p);
}
