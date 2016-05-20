package com.example.richie.liftassistant.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.richie.liftassistant.view.fragment.WeatherFragment;
import com.example.richie.liftassistant.view.fragment.WeChatFeaturedFragment;

/**
 * Fragment 适配器
 * Created by richie on 2016/5/15.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"天气","物流","精选"};
    private Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return WeatherFragment.newInstance(0);
        }else if (position==1){
            return WeatherFragment.newInstance(1);
        }else{
            return WeChatFeaturedFragment.newInstance(2);
        }

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}