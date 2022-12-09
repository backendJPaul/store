package com.jpaul.store;

import java.util.EventObject;

public class ChangeEvent extends EventObject {
    UserService userService;
    public ChangeEvent(Object object, UserService userService){
        super(object);
        this.userService = userService;

    }
}
