package com.jpaul.store;

import java.util.EventListener;

public interface IChangeEventListener extends EventListener {

    public abstract void fetch(ChangeEvent e);
    public abstract void login(ChangeEvent e);

}
