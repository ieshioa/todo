package com.green.todo.item.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdItemPositionReq {
    private int currentIndex;
    private int newIndex;
}
