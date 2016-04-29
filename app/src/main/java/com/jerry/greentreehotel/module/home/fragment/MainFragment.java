package com.jerry.greentreehotel.module.home.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.google.gson.Gson;
import com.jerry.greentreehotel.R;
import com.jerry.greentreehotel.base.BaseFragment;
import com.jerry.greentreehotel.base.EventMessage;
import com.jerry.greentreehotel.constant.Url;
import com.jerry.greentreehotel.module.home.entity.AdvertBitmap;
import com.jerry.greentreehotel.utils.HttpUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
@ContentView(R.layout.fragment_main)
public class MainFragment extends BaseFragment{
    //    private Handler handler = new Handler(){
    //        @Override
    //        public void handleMessage(Message msg){
    //            len++;
    //            if(msg.what == 1){
    //                if(len>5){
    //                    len = 0;
    //                }
    //                viewPager.setCurrentItem(len);
    //            }
    //            Log.d("MainFragment", "len:" + len);
    //            SystemClock.sleep(5000);
    //            handler.sendEmptyMessage(1);
    //        }
    //    };

    private int len;
    @ViewInject(R.id.main_view_page)
    private ViewPager viewPager;

    @ViewInject(R.id.radio_1)
    private RadioButton radioButton1;
    @ViewInject(R.id.radio_2)
    private RadioButton radioButton2;
    @ViewInject(R.id.radio_3)
    private RadioButton radioButton3;
    @ViewInject(R.id.radio_4)
    private RadioButton radioButton4;
    @ViewInject(R.id.radio_5)
    private RadioButton radioButton5;
    @ViewInject(R.id.radio_6)
    private RadioButton radioButton6;

    private LinearLayout linearLayout;

    private List<AdvertBitmap.ResponseDataBean.BannerListBean> list;
    private HttpUtil httpUtil;

    @Override
    protected void initViews(){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_frame_layout, new SearchFragment()).commit();
    }

    @Override
    protected void loadData(){
        EventBus.getDefault().register(this);
        httpUtil = HttpUtil.getInstance();
        Map<String, Object> map = new HashMap<>();
        httpUtil.sendPost(Url.ADVERT_BITMAP_URL_LIST, map);

        viewPager.postDelayed(new Runnable(){
            @Override
            public void run(){
                if(len > 5){
                    len = 0;
                    viewPager.setCurrentItem(len);
                }else {
                    viewPager.setCurrentItem(len);
                }
                len++;
                viewPager.postDelayed(this,5000);
            }
        }, 5000);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void getBitmapUrlList(EventMessage message){
        if(Url.ADVERT_BITMAP_URL_LIST.equals(message.type)){
            String data = message.result;
            Gson gson = new Gson();
            AdvertBitmap advertBitmap = gson.fromJson(message.result, AdvertBitmap.class);
            list = advertBitmap.getResponseData().getBannerList();
            final MyAdapter adapter = new MyAdapter();
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
                }

                @Override
                public void onPageSelected(int position){
                    len = position;
                    switch(position){
                        case 0:
                            radioButton1.setChecked(true);
                            break;
                        case 1:
                            radioButton2.setChecked(true);
                            break;
                        case 2:
                            radioButton3.setChecked(true);
                            break;
                        case 3:
                            radioButton4.setChecked(true);
                            break;
                        case 4:
                            radioButton5.setChecked(true);
                            break;
                        case 5:
                            radioButton6.setChecked(true);
                            break;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state){
                }
            });
            //             handler.sendEmptyMessageDelayed(1,5000);
        }
    }

    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount(){
            return list == null ? 0 : list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object){
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position){
            ImageView imageView = new ImageView(getContext());
            httpUtil.sendBitmap(imageView, list.get(position).getBannerUrl());
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            container.removeView((View) object);
        }
    }

    @Event(value = {R.id.main_menu})
    private void setMenu(View v){
        EventBus.getDefault().post(new EventMessage(R.id.main_menu + "", null));
    }
}
