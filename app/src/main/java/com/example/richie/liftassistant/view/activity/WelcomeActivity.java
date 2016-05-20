package com.example.richie.liftassistant.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.richie.liftassistant.R;
import com.example.richie.liftassistant.base.BaseActivity;

/**
 * 欢迎界面,对数据进行预加载,嗯 暂时就这样吧
 * Created by richie on 2016/5/15.
 */
public class WelcomeActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //3s后，执行run方法启动主界面Activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(i);
                //启动主Activity后销毁自身
                finish();
            }
        }, 3000);
    }

}
