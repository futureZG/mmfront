package com.mmfront.api;


import com.mmfront.base.BaseApi;
import com.mmfront.service.LoginService;

/**
 * Created by zhanggang6 on 2018/5/6.
 */

public class LoginApi {
    //    private String baseUrl = "http://gc.ditu.aliyun.com/";//阿里云根据地区名获取经纬度接口
    private String baseUrl = "http://192.168.0.160:8080/CarMon/service/";

    private volatile static LoginService loginService;

    public static LoginService getApiService() {
        if (loginService == null) {
            synchronized (LoginApi.class) {
                if (loginService == null) {
                    new LoginApi();
                }
            }
        }
        return loginService;
    }

    private LoginApi() {
        BaseApi baseApi = new BaseApi();
        loginService = baseApi.getSimpleRetrofit(baseUrl).create(LoginService.class);
    }
}
