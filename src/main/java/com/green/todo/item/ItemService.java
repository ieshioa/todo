package com.green.todo.item;

import com.green.todo.item.model.PostItemReq;
import com.green.todo.item.model.UpdItemPositionReq;
import com.green.todo.item.model.UpdItemTitleReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemMapper mapper;

    public int postItem (PostItemReq p) {
        return mapper.insItem(p);
    }

    public int updateItemTitle(UpdItemTitleReq p) {
        return mapper.updItemTitle(p);
    }

    public int updateItemPosition(UpdItemPositionReq p) {
        UpdItemPositionReq tmp = new UpdItemPositionReq();
        tmp.setNewIndex(0);
        tmp.setCurrentIndex(p.getCurrentIndex());
        mapper.updItemPositionTmp(tmp);
        mapper.updItemPosition(p);
        tmp.setCurrentIndex(0);
        tmp.setNewIndex(p.getNewIndex());
        mapper.updItemPositionTmp(tmp);
        return 1;
    }
}
