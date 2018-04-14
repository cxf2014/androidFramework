package cn.xyb100.zzqg.retrofit;

/**
 * Created by caoxuefeng on 2017/11/30.
 */


import java.util.concurrent.TimeUnit;

import cn.xyb100.zzqg.api.APIFunction;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * just()	将一个或多个对象转换成发射这个或这些对象的一个Observable
 fromArray()	将一个Iterable, 一个Future, 或者一个数组转换成一个Observable
 repeat()	创建一个重复发射指定数据或数据序列的Observable
 repeatWhen()	创建一个重复发射指定数据或数据序列的Observable，它依赖于另一个Observable发射的数据
 create()	使用一个函数从头创建一个Observable
 defer()	只有当订阅者订阅才创建Observable；为每个订阅创建一个新的Observable
 range()	创建一个发射指定范围的整数序列的Observable
 interval()	创建一个按照给定的时间间隔发射整数序列的Observable
 timer()	创建一个在给定的延时之后发射单个数据的Observable
 empty()	创建一个什么都不做直接通知完成的Observable
 error()	创建一个什么都不做直接通知错误的Observable
 never()	创建一个不发射任何数据的Observable
 */
public class RetrofitFactory {
    private static RetrofitFactory mRetrofitFactory;
    private static  APIFunction mAPIFunction;
    private RetrofitFactory(){
        OkHttpClient mOkHttpClient=new OkHttpClient.Builder()
                .connectTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .readTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .writeTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtil.HeaderInterceptor())
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .build();
        Retrofit mRetrofit=new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(mOkHttpClient)
                .build();
        mAPIFunction=mRetrofit.create(APIFunction.class);

    }

    public static RetrofitFactory getInstence(){
        if (mRetrofitFactory==null){
            synchronized (RetrofitFactory.class) {
                if (mRetrofitFactory == null)
                    mRetrofitFactory = new RetrofitFactory();
            }

        }
        return mRetrofitFactory;
    }
    public APIFunction API(){
        return mAPIFunction;
    }
}
