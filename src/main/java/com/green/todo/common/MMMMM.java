package com.green.todo.common;

import org.springframework.http.HttpStatus;

public class MMMMM {

    HttpStatus code;
    String msg;

    public void init(String msg){
        this.code = HttpStatus.OK;
        this.msg = msg;
    }
    public void noAcceptable(Exception e) {
        msg = e.getMessage();
        code = HttpStatus.NOT_ACCEPTABLE;
    }
}
