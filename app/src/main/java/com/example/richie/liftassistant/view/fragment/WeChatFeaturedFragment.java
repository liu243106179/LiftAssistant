package com.example.richie.liftassistant.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.richie.liftassistant.R;
import com.example.richie.liftassistant.bean.WeChatFeaturedResult;
import com.example.richie.liftassistant.api.ApiImpl;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 这个界面展示微信精选文章列表
 * Created by richie on 2016/5/18.
 */
public class WeChatFeaturedFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private static final String BASE_URL = "http://route.showapi.com";
    private static final String API_KEY = "d8bb354290fa4362828d71504162b231";
    private static final String APP_ID = "19189";


    public static WeChatFeaturedFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        WeChatFeaturedFragment WeChatFragment = new WeChatFeaturedFragment();
        WeChatFragment.setArguments(args);
        return WeChatFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView textView = (TextView) view;
        textView.setText("这是展示微信精选文字页面");
        query();
        return view;
    }

    private void query() {
        //1.创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                .baseUrl(BASE_URL)//主机地址
                .build();

        //2.创建访问API的请求
        ApiImpl.GetWeChatChoice service = retrofit.create(ApiImpl.GetWeChatChoice.class);
        Call<WeChatFeaturedResult> call = service.getResult(APP_ID, API_KEY, "10", "0", "", "1");


        //3.发送请求
        call.enqueue(new Callback<WeChatFeaturedResult>() {
            @Override
            public void onResponse(Call<WeChatFeaturedResult> call, Response<WeChatFeaturedResult> response) {
                //4.处理结果
                if (response.isSuccessful()) {
                    WeChatFeaturedResult result = response.body();
                    if (result != null) {
                        WeChatFeaturedResult.ShowapiResBodyBean entity = result.getShowapi_res_body();
                    }
                }
            }

            @Override
            public void onFailure(Call<WeChatFeaturedResult> call, Throwable t) {

            }

        });
    }

}
