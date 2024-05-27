package com.green.todo.item.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdItemTitleReq {
    private long itemIndex;
    private String itemTitle;
}
