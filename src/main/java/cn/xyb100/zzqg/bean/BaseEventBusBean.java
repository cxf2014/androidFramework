package cn.xyb100.zzqg.bean;

/**
 * Created by caoxuefeng on 2017/11/16.
 * EventBus传递消息总体类
 */

public class BaseEventBusBean<T> {
    private int eventCode = -1;

    private T data;

    public BaseEventBusBean(int eventCode) {
        this.eventCode = eventCode;
    }

    public BaseEventBusBean(int eventCode, T data) {
        this.eventCode = eventCode;
        this.data = data;
    }

    public int getEventCode() {
        return eventCode;
    }

    public T getData() {
        return data;
    }
}
