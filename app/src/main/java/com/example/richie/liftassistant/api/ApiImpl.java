package com.example.richie.liftassistant.api;

import com.example.richie.liftassistant.bean.WeChatFeaturedResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit 网络请求接口
 * Created by richie on 2016/5/21.
 */
public class ApiImpl {

    /**
     * 获取微信精选文章列表
     * 提供者ShowApi .
     */
    public interface GetWeChatChoice {
        @GET("/582-2")
        Call<WeChatFeaturedResult> getResult(@Query("showapi_appid") String my_appId, @Query("showapi_sign")String my_Secret,
                                             @Query("page")String page);
    }
}
