package com.example.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.myapplication.DepartmentsActivity;
import com.example.myapplication.DrugActivity;
import com.example.myapplication.R;
import com.example.myapplication.SearchActivity;

/**
 * Created by 郭仲凯 on 2016/11/11.
 */

    public class illtest extends Fragment implements View.OnClickListener {
    private Context context;


    private ImageView milltest_search_img;
    private RelativeLayout mzicha_zicha_rl;
    private RelativeLayout mzicha_keshi_rl;
    private RelativeLayout mzicha_yaopin_rl;
    private RelativeLayout mzicha_yaodian_rl;
    private RelativeLayout mzicha_yiyuan_rl;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_illtest,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        //初始化控件
        initView(view);

        initClick();


    }
    //点击事件
    private void initClick() {
        milltest_search_img.setOnClickListener(this);
        mzicha_yiyuan_rl.setOnClickListener(this);
        mzicha_yaopin_rl.setOnClickListener(this);
        mzicha_keshi_rl.setOnClickListener(this);
        mzicha_zicha_rl.setOnClickListener(this);
        mzicha_yaodian_rl.setOnClickListener(this);
    }

    private void initView(View view) {
        milltest_search_img = (ImageView) view.findViewById(R.id.illtest_search_img);
        mzicha_zicha_rl = (RelativeLayout) view.findViewById(R.id.zicha_zicha_rl);
        mzicha_keshi_rl = (RelativeLayout) view.findViewById(R.id.zicha_keshi_rl);
        mzicha_yaopin_rl = (RelativeLayout) view.findViewById(R.id.zicha_yaopin_rl);
        mzicha_yaodian_rl = (RelativeLayout) view.findViewById(R.id.zicha_yaodian_rl);
        mzicha_yiyuan_rl = (RelativeLayout) view.findViewById(R.id.zicha_yiyuan_rl);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.illtest_search_img:
                startActivity(new Intent(context, SearchActivity.class));
                break;
            case R.id.zicha_zicha_rl:

                break;
            case R.id.zicha_keshi_rl:
                Intent intent1  = new Intent(context, DepartmentsActivity.class);
                startActivity(intent1);
                break;
            case R.id.zicha_yaopin_rl:
                startActivity(new Intent(context, DrugActivity.class));
                break;
            case R.id.zicha_yaodian_rl:

                break;
            case R.id.zicha_yiyuan_rl:

                break;

        }
    }
}
