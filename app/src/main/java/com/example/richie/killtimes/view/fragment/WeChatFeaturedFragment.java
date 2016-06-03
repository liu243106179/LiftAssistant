
package com.example.richie.killtimes.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.richie.killtimes.R;
import com.example.richie.killtimes.adapter.WeChatFeatureRecyclerAdapter;
import com.example.richie.killtimes.model.bean.WeChatFeaturedResult;
import com.example.richie.killtimes.model.http.ApiImpl;
import com.example.richie.killtimes.widget.DividerItemDecoration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import butterknife.OnClick;

import static com.example.richie.killtimes.model.config.ApiConstant.BASE_URL;


/**
 * 微信精选文章
 * Created by richie on 2016/5/18.
 */
public class WeChatFeaturedFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private Subscriber subscriber;
    private static final String API_SIGN = "C1D3D88659575EADCE68DEB0059F3BFF";
    private static final String APP_ID = "19276";
    private String page = "1";
    private int mPage;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

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
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        initSwipeRefreshLayout();

        swipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        }, 2000);
        return view;
    }

    private void initSwipeRefreshLayout() {
        //设置圆圈背景颜色
        swipeRefreshLayout.setBackgroundColor(getResources().getColor(R.color.colorGhostWhite));
        //设置进度动画颜色
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorDodgerBlue));
        //设置进度偏移量
        swipeRefreshLayout.setProgressViewOffset(false,0,100);
        //设置swipeRefreshLayout item 点击事件
        swipeRefreshLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                //3s后，执行run方法启动主界面Activity
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                }, 2000);
//            }
//        });
    }

    private void setAdapter(WeChatFeaturedResult weChatFeaturedResult) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration());
        mRecyclerView.setAdapter(new WeChatFeatureRecyclerAdapter(getActivity(), weChatFeaturedResult));
    }

    private void initData() {
        swipeRefreshLayout.setRefreshing(false);
//        subscriber = new Subscriber<WeChatFeaturedResult>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(WeChatFeaturedResult weChatFeaturedResult) {
////                swipeRefreshLayout.setRefreshing(false);
//                setAdapter(weChatFeaturedResult);
//            }
//        };
//        HttpMethods.getInstance().getWeChatChoiceList(subscriber,APP_ID,API_SIGN,page);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiImpl.GetWeChatChoiceService service = retrofit.create(ApiImpl.GetWeChatChoiceService.class);
        Call<WeChatFeaturedResult> call = service.getWeChatChoiceList(APP_ID, API_SIGN,"1");
        call.enqueue(new Callback<WeChatFeaturedResult>() {
            @Override
            public void onResponse(Call<WeChatFeaturedResult> call, Response<WeChatFeaturedResult> response) {
                setAdapter(response.body());
            }

            @Override
            public void onFailure(Call<WeChatFeaturedResult> call, Throwable t) {
                Log.e("Throwable",t.getMessage());
            }
        });
//        service.getWeChatChoiceList(APP_ID, API_SIGN,"1")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<WeChatFeaturedResult>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(WeChatFeaturedResult weChatFeaturedResult) {
//                        setAdapter(weChatFeaturedResult);
//                    }
//                });
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