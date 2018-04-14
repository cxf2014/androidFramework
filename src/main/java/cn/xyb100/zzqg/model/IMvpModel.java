package cn.xyb100.zzqg.model;

import cn.xyb100.zzqg.presenter.IRequestResultCallback;

/**
 * Created by caoxuefeng on 2017/11/29.
 */

public interface IMvpModel {
    <T> void getData(IRequestResultCallback requestResultCallback,Class<T> cls);
}
