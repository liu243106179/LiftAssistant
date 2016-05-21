package com.example.richie.liftassistant.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.richie.liftassistant.R;
import com.example.richie.liftassistant.adapter.WeChatFeatureRecyclerAdapter;
import com.example.richie.liftassistant.api.ApiImpl;
import com.example.richie.liftassistant.bean.WeChatFeaturedResult;
import com.example.richie.liftassistant.widget.DividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
//    @BindView(R.id.recycler_view)
//    RecyclerView recyclerView;
//    @BindView(R.id.swipe_refresh_widget)
//    SwipeRefreshLayout swipeRefreshWidget;

    private int mPage;
    private static final String BASE_URL = "http://route.showapi.com";
    private static final String API_SIGN = "5aa5b8300af74d6e90b0562865cb2dc5";
    private static final String APP_ID = "19276";
    private String page = "1";
    private WeChatFeaturedResult result;
    private RecyclerView mRecyclerView;

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
        View view = inflater.inflate(R.layout.featurefragment_page, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        initData();
        return view;
    }




    private void setAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration());
        mRecyclerView.setAdapter(new WeChatFeatureRecyclerAdapter(getActivity(), result));
    }

    private void initData() {
        //1.创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                .baseUrl(BASE_URL)//主机地址
                .build();

        //2.创建访问API的请求
        ApiImpl.GetWeChatChoice service = retrofit.create(ApiImpl.GetWeChatChoice.class);
        Call<WeChatFeaturedResult> call = service.getResult(APP_ID, API_SIGN, page);


        //3.发送请求
        call.enqueue(new Callback<WeChatFeaturedResult>() {
            @Override
            public void onResponse(Call<WeChatFeaturedResult> call, Response<WeChatFeaturedResult> response) {
                //4.处理结果
                if (response.isSuccessful()) {
                    result = response.body();
                    if (result != null) {
                        setAdapter();
                    }
                }
            }

            @Override
            public void onFailure(Call<WeChatFeaturedResult> call, Throwable t) {

            }

        });
    }


    @OnClick({R.id.recycler_view, R.id.swipe_refresh_widget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recycler_view:
                break;
            case R.id.swipe_refresh_widget:
                break;
        }
    }
}
