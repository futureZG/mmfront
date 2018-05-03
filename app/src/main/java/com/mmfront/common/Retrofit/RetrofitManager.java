package com.mmfront.common.Retrofit;

import com.mmfront.common.util.CommonConstants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by My on 2018/5/1.
 */

public class RetrofitManager {
    private volatile static RetrofitManager retrofitManager;

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private Retrofit retrofit;

    public static RetrofitManager getSingleton(){
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class){
                retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager;
    }
    private RetrofitManager(){
        initRetrofitManager();
    }

    private void initRetrofitManager() {
        retrofit = new Retrofit.Builder().baseUrl(CommonConstants.APP_PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
