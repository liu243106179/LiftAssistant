package com.example.richie.killtimes.view.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.richie.killtimes.R;
import com.example.richie.killtimes.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by richie on 2016/5/22.
 */

public class WeChatFeaturedShowActivity extends BaseActivity {
    @BindView(R.id.WebView_FeaturedShow)
    WebView WebViewFeaturedShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_show);
        ButterKnife.bind(this);
    }


}
