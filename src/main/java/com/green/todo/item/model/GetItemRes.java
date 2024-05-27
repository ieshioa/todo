package com.green.todo.item.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetItemRes {
    private long itemIndex;
    private String itemTitle;
    private String createdAt;
    private int itemPosition;
}
