package com.example.richie.killtimes.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 设置RecyclerView间距 ,达到ListView中dividerHeight/dividerColor效果
 * Created by richie on 2016/5/21.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //设置高度为1的间距
        outRect.set(0,0,0,15);
    }
}
