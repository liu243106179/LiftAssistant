package com.example.richie.liftassistant.model.http;

import com.example.richie.liftassistant.model.bean.WeChatFeaturedResult;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.richie.liftassistant.model.config.ApiConstant.BASE_URL;

/**
 * Created by richie on 2016/6/1.
 */

public class HttpMethods {
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private ApiImpl.GetWeChatChoiceService service;
    //构造方法私有
    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        service = retrofit.create(ApiImpl.GetWeChatChoiceService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //获取单例
    public static HttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用于获取微信精选文章列表
     * @param subscriber 由调用者传过来的观察者对象
     * @param my_appId 易源应用id
     * @param my_Secret 签名
     * @param page 第几页
     */
    public void getWeChatChoiceList(Subscriber<WeChatFeaturedResult> subscriber, String my_appId, String my_Secret,String page){
        service.getWeChatChoiceList(my_appId, my_Secret,page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
