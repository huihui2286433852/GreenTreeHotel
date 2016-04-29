package com.jerry.greentreehotel;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchListItemAdapter extends BaseAdapter {

    private List<ItemsBean> objects = new ArrayList<ItemsBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public SearchListItemAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public T getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.search_list_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((ItemsBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
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
