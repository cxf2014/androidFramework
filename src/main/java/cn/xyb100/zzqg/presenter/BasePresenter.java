package cn.xyb100.zzqg.presenter;

import cn.xyb100.zzqg.view.BaseView;

/**
 * Presenter 作用处理view跟model层之间的逻辑
 * Created by caoxuefeng on 2017/11/29.
 */

public interface BasePresenter<V extends BaseView>{
    void attachView(V view);

    void detachView();
}
