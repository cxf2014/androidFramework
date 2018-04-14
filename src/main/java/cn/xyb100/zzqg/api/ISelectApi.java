package cn.xyb100.zzqg.api;

import cn.xyb100.zzqg.bean.SelectBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by caoxuefeng on 2017/11/29.
 */

public interface ISelectApi {
    @GET("/users/{user}")
    Call<SelectBean> repo(@Path("user") String user);

    @GET("/users/{user}")
    Observable<SelectBean> select(@Path("user") String user);

    @GET("/users/Guolei1130")
    Observable<SelectBean> select();
}
