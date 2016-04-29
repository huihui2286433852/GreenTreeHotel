package com.jerry.greentreehotel.module.home.fragment;

import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jerry.greentreehotel.R;
import com.jerry.greentreehotel.base.BaseFragment;
import com.jerry.greentreehotel.base.EventMessage;
import com.jerry.greentreehotel.constant.Url;
import com.jerry.greentreehotel.module.home.adapter.SearchListAdapter;
import com.jerry.greentreehotel.module.home.entity.TavernMessage;
import com.jerry.greentreehotel.utils.HttpUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
@ContentView(R.layout.fragment_search_list)
public class SearchListFragment extends BaseFragment{

    private int pageindex = 1;

    @ViewInject(R.id.search_list)
    private PullToRefreshListView listView;
    private SearchListAdapter adapter;

    @Override
    protected void initViews(){
        EventBus.getDefault().register(this);


        listView.getRefreshableView().setDivider(null);
        listView.getRefreshableView().setSelector(android.R.color.transparent);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>(){
            //下拉刷新
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView){
                pageindex = 1;
                updateData();
            }

            //上啦加载
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView){
                pageindex++;
                updateData();
            }
        });
    }

    @Override
    protected void loadData(){
        updateData();


        adapter = new SearchListAdapter(getContext());
        listView.setAdapter(adapter);
    }

    private void updateData(){
        Map<String, Object> map = new HashMap<>();
        map.put("pagesize",10);
        map.put("pageindex",pageindex);
        //        pagesize
        //        当前页数（用于分页，下一页就加一）
        //        days
        //        天数（在《首页》入住天数处  得到）
        //        cityId
        //        城市id（在《首页》入住城市处得到id）
        //        keyword
        //        搜索关键字（在《首页》关键词处得到）
        //        checkintime
        //        入住时间（在《首页》入住时间处  得到）
        //        ordertype
        //        排序方式（在酒店列表处得到，默认为0-推荐）
        HttpUtil.getInstance().sendPost(Url.SEARCH_LIST,map);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void getSearchList(EventMessage message){
        if(Url.SEARCH_LIST.equals(message.type)){
            Gson gson = new Gson();
            TavernMessage tavernMessage = gson.fromJson(message.result, TavernMessage.class);
            if(pageindex == 1){
                adapter.getList().clear();
                adapter.getList().addAll(tavernMessage.getResponseData().getItems());
            }else {
                adapter.getList().addAll(tavernMessage.getResponseData().getItems());
            }
            adapter.notifyDataSetChanged();
            listView.onRefreshComplete();
        }
    }

}
