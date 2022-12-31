package com.sun.common;

import org.springframework.stereotype.Component;

@Component
public class LocalIdThread<T> {

    private ThreadLocal<T> threadLocal;

    public LocalIdThread(){
        this.threadLocal=new ThreadLocal<T>();
    }

    public void set(T value){
        this.threadLocal.set(value);
    }

    public T get(){
        return this.threadLocal.get();
    }
}
