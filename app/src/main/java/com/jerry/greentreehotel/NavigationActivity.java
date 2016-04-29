package com.jerry.greentreehotel;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jerry.greentreehotel.base.BaseActivity;
import com.jerry.greentreehotel.base.EventMessage;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_navigation)
public class NavigationActivity extends BaseActivity{

    private int[] imgIds = {};

    @ViewInject(R.id.view_page)
    private ViewPager viewPager;

    @ViewInject(R.id.group)
    private RadioGroup group;

    @ViewInject(R.id.radio1)
    private RadioButton radio1;
    @ViewInject(R.id.radio2)
    private RadioButton radio2;
    @ViewInject(R.id.radio3)
    private RadioButton radio3;

    @Override
    public void onGetResult(EventMessage message){
    }

    @Override
    protected void initViews(){
    }

    @Override
    protected void loadData(){


    }




    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount(){
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object){
            return view ==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position){
            ImageView imageView = new ImageView(NavigationActivity.this);
            container.addView(imageView);
            return imageView;
        }
    }
}
