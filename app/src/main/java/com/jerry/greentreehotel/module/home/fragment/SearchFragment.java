package com.jerry.greentreehotel.module.home.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.jerry.greentreehotel.R;
import com.jerry.greentreehotel.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

/**
 * A simple {@link Fragment} subclass.
 */
@ContentView(R.layout.fragment_search)
public class SearchFragment extends BaseFragment{

    @Override
    protected void initViews(){

    }

    @Override
    protected void loadData(){
    }
    @Event(R.id.fragment_search)
    private void onClickSearch(View view){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,new SearchListFragment())
                .commit();
    }
}
