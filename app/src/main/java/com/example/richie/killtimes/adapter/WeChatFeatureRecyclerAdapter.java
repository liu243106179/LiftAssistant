package com.example.richie.killtimes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.richie.killtimes.R;
import com.example.richie.killtimes.model.bean.WeChatFeaturedResult;
import com.squareup.picasso.Picasso;

/**
 * Created by richie on 2016/5/21.
 */

public class WeChatFeatureRecyclerAdapter extends RecyclerView.Adapter<WeChatFeatureRecyclerAdapter.MyViewHolder> {

    private final Context context;
    private final LayoutInflater mLayoutInflater;
    private WeChatFeaturedResult result;

    public WeChatFeatureRecyclerAdapter(Context mContext,WeChatFeaturedResult result) {
        this.result = result;
        context = mContext;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(mLayoutInflater.inflate(R.layout.item_featurefragment, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_title_name.setText(result.getShowapi_res_body().getPagebean().getContentlist().get(position).getTypeName());
        holder.tv_content.setText(result.getShowapi_res_body().getPagebean().getContentlist().get(position).getTitle());
        holder.tv_data.setText(result.getShowapi_res_body().getPagebean().getContentlist().get(position).getDate());
        Picasso.with(context).load(result.getShowapi_res_body().getPagebean().getContentlist().get(position).getContentImg()).into(holder.img_content);
        Picasso.with(context).load(result.getShowapi_res_body().getPagebean().getContentlist().get(position).getUserLogo()).into(holder.img_title);

    }

    @Override
    public int getItemCount() {
        return result.getShowapi_res_body().getPagebean().getContentlist().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title_name;
        private TextView tv_content;
        private TextView tv_data;
        private ImageView img_content;
        private ImageView img_title;

        public MyViewHolder(View view) {
            super(view);
            tv_title_name = (TextView) view.findViewById(R.id.tv_title_name);
            tv_content = (TextView) view.findViewById(R.id.tv_content);
            tv_data = (TextView) view.findViewById(R.id.tv_data);
            img_content = (ImageView) view.findViewById(R.id.img_content);
            img_title = (ImageView) view.findViewById(R.id.img_title);
        }
    }
}
