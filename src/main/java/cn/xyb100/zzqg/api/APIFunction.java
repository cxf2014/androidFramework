package cn.xyb100.zzqg.api;

import com.google.gson.JsonObject;

import cn.xyb100.zzqg.bean.SelectBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by caoxuefeng on 2018/1/25.
 */

public interface APIFunction<T> {
    @GET(URLConfig.rela_path)
    Observable<Object> getBaidu(@Query("wd") String name);

    @GET("/users/Guolei1130")
    Observable<SelectBean> select();

    @GET("users/Guolei1130")
    Observable<Object> test();

    @GET("{url}")
    Observable<JsonObject> test(@Path(value = "url", encoded = true) String url);

    @POST("{url}")
    Observable<JsonObject> testPost(@Path(value = "url", encoded = true) String url);

    @FormUrlEncoded
    @POST("User/login")
    Observable<JsonObject> login(@Field("mobile") String mobile, @Field("password") String password);
}
