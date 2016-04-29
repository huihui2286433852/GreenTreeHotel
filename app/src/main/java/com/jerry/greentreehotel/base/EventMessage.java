package com.jerry.greentreehotel.base;

/**
 * Created by huanghui on 2016/4/28.
 */
public class EventMessage{
    public EventMessage(String type, String result){
        this.type = type;
        this.result = result;
    }

    public String type;
    public String result;
}
