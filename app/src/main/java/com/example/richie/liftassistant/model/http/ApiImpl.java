package com.example.richie.liftassistant.model.http;

import com.example.richie.liftassistant.model.bean.WeChatFeaturedResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by richie on 2016/5/21.
 */
public class ApiImpl {
    //微信精选文章
    public interface GetWeChatChoiceService {
        @GET("/582-2")
        Observable<WeChatFeaturedResult> getWeChatChoiceList(@Query("showapi_appid") String my_appId, @Query("showapi_sign")String my_Secret,
                                                   @Query("page")String page);
    }
}
