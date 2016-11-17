package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.bean.DrugBean;
import com.example.myapplication.utils.MyCustomRequest;
import com.example.myapplication.utils.UrlUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/14/014.
 */

public class DrugActivity extends AppCompatActivity implements View.OnClickListener{
    private ExpandableListView elv_drug;
    private Button mbut_drug_back;
    private Button mbut_drug_search;


    private RequestQueue queue;
    private MyExAdapter adapter;

    private ActionBar bar;

    private final String TAG = "tmd";

    private ArrayList<DrugBean.ListBean> drugList = new ArrayList<DrugBean.ListBean>();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug);
        initView();

        mbut_drug_back.setOnClickListener(this);
        mbut_drug_search.setOnClickListener(this);

        bar = getSupportActionBar();

        queue = Volley.newRequestQueue(DrugActivity.this);

        initData();

        initAdapter();

        //设置父条目图标的显示
        elv_drug.setGroupIndicator(null);


        //设置子条目的点击事件
        elv_drug.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(DrugActivity.this,i+""+i1,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    private void initAdapter() {
        adapter  = new MyExAdapter();
        elv_drug.setAdapter(adapter);
    }

    //初始化数据源
    private void initData() {
        MyCustomRequest<DrugBean> mcr = new MyCustomRequest<DrugBean>(UrlUtils.DRUG_URL, DrugBean.class,
                new Response.Listener<DrugBean>() {
                    @Override
                    public void onResponse(DrugBean response) {
                        drugList.addAll(response.getList());
                        Log.i(TAG, "onResponse: "+drugList.size());
                        adapter.notifyDataSetChanged();
                    }
                },null);
        queue.add(mcr);
    }

    private void initView() {
        elv_drug = (ExpandableListView) findViewById(R.id.elv_drug);
        mbut_drug_back = (Button) findViewById(R.id.but_drug_back);
        mbut_drug_search = (Button) findViewById(R.id.but_drug_search);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_drug_back:
                finish();
                break;
            case R.id.but_drug_search:
         //       startActivity(new Intent(DrugActivity.this,));
                break;
        }
    }

    class MyExAdapter extends BaseExpandableListAdapter{


        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public int getGroupCount() {
            return drugList.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return drugList.get(i).getContent().size();
        }

        @Override
        public Object getGroup(int i) {
            return null;
        }

        @Override
        public Object getChild(int i, int i1) {
            return null;
        }

        @Override
        public long getGroupId(int i) {
            return 0;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            GroupHolder holder;
            if(view == null){
                view = LayoutInflater.from(DrugActivity.this).inflate(R.layout.drug_group_item,viewGroup,false);
                holder = new GroupHolder();
                holder.tv1_group = (TextView) view.findViewById(R.id.tv1_group_drug);
                holder.tv2_group = (TextView) view.findViewById(R.id.tv2_group_drug);
                holder.img_group = (ImageView) view.findViewById(R.id.img_group_drug);


                view.setTag(holder);
            }else {
                holder = (GroupHolder) view.getTag();
            }
            Log.i(TAG, "getGroupView: "+i);
            holder.tv1_group.setText(drugList.get(i).getFirst()+"");
            holder.tv2_group.setText(drugList.get(i).getTitle()+"");
            if(b){
                holder.img_group.setBackgroundResource(R.mipmap.ic_group_arrow_open);
                holder.tv1_group.setBackgroundResource(R.mipmap.drug_bg_green);
            }else {
                holder.img_group.setBackgroundResource(R.mipmap.ic_group_arrow_close);
                holder.tv1_group.setBackgroundResource(R.mipmap.drug_bg_blue);
            }

            return view;
        }

        class GroupHolder{
            TextView tv1_group;
            TextView tv2_group;
            ImageView img_group;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            ChildHolder holder;
            if (view == null){
                view = LayoutInflater.from(DrugActivity.this).inflate(R.layout.drug_child_item,viewGroup,false);
                holder = new ChildHolder();
                holder.tv1_child = (TextView) view.findViewById(R.id.tv1_child_drug);
                holder.tv2_child = (TextView) view.findViewById(R.id.tv2_child_drug);

                view.setTag(holder);
            }else{
                holder = (ChildHolder) view.getTag();
            }
            holder.tv1_child.setText(drugList.get(i).getContent().get(i1).getName()+"");
            holder.tv2_child.setText(drugList.get(i).getContent().get(i1).getNum()+"");

            return view;

        }
        class ChildHolder{
            TextView tv1_child;
            TextView tv2_child;

        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }
}
