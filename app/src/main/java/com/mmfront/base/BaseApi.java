package com.mmfront.base;






import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by zhanggang6 on 2018/5/6.
 * 网络对象层
 */

public class BaseApi {
    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 7676;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 7676;

    /**
     * 无超时及缓存策略的Retrofit
     *
     * @param baseUrl
     * @return
     */
//    public Retrofit getSimpleRetrofit(String baseUrl) {
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(ScalarsConverterFactory.create())//请求结果转换为基本类型，一般为String
//                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//适配RxJava2.0,
//                // RxJava1.x则为RxJavaCallAdapterFactory.create()
//                .build();
//        return retrofit;
//    }

    /**
     * 使用OkHttp配置了超时及缓存策略的Retrofit
     *
     * @param baseUrl
     * @return
     */
    public Retrofit getRetrofit(String baseUrl) {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //缓存
        //File cacheFile = new File(BaseApplication.getContext().getCacheDir(), "cache");
        //Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        //增加头部信息
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request build = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")//设置允许请求json数据
                        .build();
                return chain.proceed(build);
            }
        };

        //创建一个OkHttpClient并设置超时时间
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
//                .addInterceptor(mRewriteCacheControlInterceptor)
//                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                .addInterceptor(headerInterceptor)
                .addInterceptor(logInterceptor)
             //   .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())//请求结果转换为基本类型，一般为String
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//适配RxJava2.0,
                // RxJava1.x则为RxJavaCallAdapterFactory.create()
                .build();
        return retrofit;

    }



    /**
     * 设缓存有效期为两天
     */
//    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
//
//    /**
//     * 云端响应头拦截器，用来配置缓存策略
//     * Dangerous interceptor that rewrites the server's cache-control header.
//     */
//    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            String cacheControl = request.cacheControl().toString();
//            if (!NetWorkUtil.isNetConnected(BaseApplication.getContext())) {
//                request = request.newBuilder()
//                        .cacheControl(TextUtils.isEmpty(cacheControl) ? CacheControl
//                                .FORCE_NETWORK : CacheControl.FORCE_CACHE)
//                        .build();
//            }
//            Response originalResponse = chain.proceed(request);
//            if (NetWorkUtil.isNetConnected(BaseApplication.getContext())) {
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", cacheControl)
//                        .removeHeader("Pragma")
//                        .build();
//            } else {
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" +
//                                CACHE_STALE_SEC)
//                        .removeHeader("Pragma")
//                        .build();
//            }
//        }
//    };
}
