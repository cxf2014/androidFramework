package cn.xyb100.zzqg.presenter;

import cn.xyb100.zzqg.response.BaseResponse;
import cn.xyb100.zzqg.view.BaseView;
import cn.xyb100.zzqg.bean.SelectBean;
import cn.xyb100.zzqg.model.IMvpModel;
import cn.xyb100.zzqg.model.MvpModel;

/**
 * Created by caoxuefeng on 2017/11/29.
 */

public class MvpPresenter<T extends BaseResponse,V extends BaseView> implements IMvpPresenter<V>,IRequestResultCallback<T>{
    private IMvpModel selectModel;
    private V view;

    public MvpPresenter(){
        selectModel = new MvpModel();
    }

    @Override
    public void requestData(Class t) {
        selectModel.getData(this,t);
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void success(T t) {
        SelectBean sb = (SelectBean)t;
        view.showCurContent(t);
    }

    @Override
    public void fail(Object obj) {

    }

}
