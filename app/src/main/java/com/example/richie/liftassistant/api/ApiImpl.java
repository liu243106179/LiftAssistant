package com.example.richie.liftassistant.api;

import com.example.richie.liftassistant.bean.WeChatFeaturedResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Retrofit 网络请求接口
 * Created by richie on 2016/5/21.
 */
public class ApiImpl {

    /**
     * 获取微信精选文字list
     * 提供者ShowApi .
     */
    public interface GetWeChatChoice {
        @GET("/181-1")
        Call<WeChatFeaturedResult> getResult(@Header("showapi_appid") String my_appId, @Header("secret")String my_Secret,
                                             @Query("num") String num, @Query("rand")String rand, @Query("word")String word, @Query("page") String page);
    }



}
