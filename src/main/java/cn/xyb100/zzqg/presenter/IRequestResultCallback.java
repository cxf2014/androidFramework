package cn.xyb100.zzqg.presenter;

/**
 * Created by caoxuefeng on 2017/11/29.
 */

public interface IRequestResultCallback<T> {
    void success(T t);

    void fail(Object obj);
}
