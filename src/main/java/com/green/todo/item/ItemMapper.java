package com.green.todo.item;

import com.green.todo.item.model.PostItemReq;
import com.green.todo.item.model.UpdItemPositionReq;
import com.green.todo.item.model.UpdItemTitleReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
    int insItem(PostItemReq p);
    int updItemTitle(UpdItemTitleReq p);
    int updItemPosition(UpdItemPositionReq t);
    int updItemPositionTmp(UpdItemPositionReq t);
}
