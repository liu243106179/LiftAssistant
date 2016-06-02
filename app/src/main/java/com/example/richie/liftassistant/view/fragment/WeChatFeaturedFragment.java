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
import com.example.richie.liftassistant.model.bean.WeChatFeaturedResult;
import com.example.richie.liftassistant.model.http.HttpMethods;
import com.example.richie.liftassistant.widget.DividerItemDecoration;

import butterknife.OnClick;
import rx.Subscriber;

/**
 * 微信精选文章
 * Created by richie on 2016/5/18.
 */
public class WeChatFeaturedFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private Subscriber subscriber;
    private static final String API_SIGN = "5aa5b8300af74d6e90b0562865cb2dc5";
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
        initSwipeRefreshLayout();
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
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });
    }

    private void setAdapter(WeChatFeaturedResult weChatFeaturedResult) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration());
        mRecyclerView.setAdapter(new WeChatFeatureRecyclerAdapter(getActivity(), weChatFeaturedResult));
    }

    private void initData() {
        subscriber = new Subscriber<WeChatFeaturedResult>() {
            @Override
            public void onCompleted() {
                swipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(WeChatFeaturedResult weChatFeaturedResult) {
                swipeRefreshLayout.setRefreshing(false);
                setAdapter(weChatFeaturedResult);
            }
        };
        HttpMethods.getInstance().getWeChatChoiceList(subscriber,APP_ID,API_SIGN,page);
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
