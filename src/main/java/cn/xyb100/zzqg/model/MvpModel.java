package cn.xyb100.zzqg.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cn.xyb100.zzqg.logger.Logger;
import cn.xyb100.zzqg.presenter.IRequestResultCallback;
import cn.xyb100.zzqg.retrofit.ExceptionHandle;
import cn.xyb100.zzqg.retrofit.RetrofitFactory;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * model存的作用提供数据和保存数据
 * Created by caoxuefeng on 2017/11/29.
 */

public class MvpModel implements IMvpModel {


    /**
     * retrofit网络请求实例
     * String API_BASE_URL = "https://api.github.com/";
     *
     * @param requestResultCallback
     */
    @Override
    public <T> void getData(final IRequestResultCallback requestResultCallback,final Class<T> cls) {
        RetrofitFactory.getInstence().API()
                .test("users/Guolei1130")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JsonObject>() {
                    @Override
                    public void accept(@NonNull JsonObject object) throws Exception {
                        //这里接收数据项
                        Logger.e(new Gson().toJson(object) + "是否成功-----------------");
                        if (requestResultCallback != null) {
                            T t = new Gson().fromJson(new Gson().toJson(object),cls);
                            Logger.e("--"+new Gson().toJson(t) + "是否成功-----------------");
                            requestResultCallback.success(t);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        //这里接收onError
                        Logger.e( ExceptionHandle.handleException(throwable).message+ "---错误信息-----------------");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        //这里接收onComplete。
                        Logger.e( "是否完成-----------------");
                    }
                });
    }
}
