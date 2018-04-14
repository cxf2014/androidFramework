package cn.xyb100.zzqg.presenter;

import cn.xyb100.zzqg.view.BaseView;

/**
 * Created by caoxuefeng on 2017/11/29.
 */

public interface IMvpPresenter<V extends BaseView> extends BasePresenter<V>{
    void requestData(Class t);
}
