package com.jerry.greentreehotel.module.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jerry.greentreehotel.R;
import com.jerry.greentreehotel.module.home.entity.TavernMessage;
import com.jerry.greentreehotel.utils.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanghui on 2016/4/28.
 */
public class SearchListAdapter extends BaseAdapter{
    private List<TavernMessage.ResponseDataBean.ItemsBean> list = new ArrayList<TavernMessage.ResponseDataBean.ItemsBean>();

    private Context context;
    private LayoutInflater layoutInflater;
    private HttpUtil httpUtil = HttpUtil.getInstance();

    public List<TavernMessage.ResponseDataBean.ItemsBean> getList(){
        return list;
    }

    public SearchListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public TavernMessage.ResponseDataBean.ItemsBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.search_list_item, null);
            view.setTag(new ViewHolder(view));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tvHotelName.setText(getItem(position).getName());
        holder.tvHotelScore.setText(getItem(position).getScore());
        httpUtil.sendBitmap(holder.ivHotel,getItem(position).getImageUrl());
        return view;
    }


    protected class ViewHolder {
        private ImageView ivHotel;
        private TextView tvHotelName;
        private TextView tvHotelScore;

        public ViewHolder(View view) {
            ivHotel = (ImageView) view.findViewById(R.id.iv_hotel);
            tvHotelName = (TextView) view.findViewById(R.id.tv_hotel_name);
            tvHotelScore = (TextView) view.findViewById(R.id.tv_hotel_score);
        }
    }
}
