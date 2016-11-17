package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.adapter.MyAdapter;
import com.example.myapplication.adapter.SubAdapter;

/**
 * Created by Administrator on 2016/11/13/013.
 * 常见科室页面
 */

public class DepartmentsActivity extends Activity {

    private ListView mylistView;
    private ListView subListView;
    private MyAdapter myAdapter;
    private SubAdapter subAdapter;
    private Button mbut_department;


     String strs[][] = new String[][]{
             new String[]{"冠心病","肺结核","流行性腮腺炎","结膜炎","肋骨骨折","膀胱炎","营养不良","胰腺炎"},
             new String[]{"流行性感冒","糖尿病","急性上呼吸道感染","慢性肾小球炎症","肾损伤","贫血","血友病","风湿性疾病"},
             new String[]{"痔疮","烧伤整形","乳腺增生","前列腺炎","尿道损伤","前列腺增生","肾结石"},
             new String[]{"小儿感冒","小儿支气管炎","小儿贫血","尿布疹","百日咳","小儿多动症","手足口病"},
             new String[]{"妊娠期高血压","卵巢囊肿","宫颈炎","阴道炎","盆腔炎","附件炎","痛经","宫外孕"},
             new String[]{"白内障","散光","沙眼","角膜炎","干眼症","青光眼","黄斑变性","龋齿","口腔溃疡",
                     "牙周炎","牙龈炎","根管治疗","烤瓷牙","中耳炎","耳聋","外耳炎"},
             new String[]{"梅毒","淋病","皮肤过敏","斑秃","痤疮","湿疹","银屑病","足癣","冻疮","尖锐湿疹"},
             new String[]{"疟疾","狂犬病","乙型病毒性肝炎","病毒性肝炎","艾滋病","破伤风"},
             new String[]{"失眠","抑郁病","精神分裂症","强迫症","恐惧症","自闭症","心理障碍","性心理疾病"},
             new String[]{"心功能不全","食物中毒","休克","呼吸衰竭","一氧化碳中毒","失血性休克"}};

    String strss[] = new String[]{"常见疾病","内科","外科","儿科","妇产科","五官科","皮肤科","传染疾病","心理科","其他科室"};

    int images[] = new int[]{R.mipmap.img_new_department1,R.mipmap.img_new_department2,R.mipmap.img_new_department3,R.mipmap.img_new_department4,
            R.mipmap.img_new_department5,R.mipmap.img_new_department6,R.mipmap.img_new_department7,R.mipmap.img_new_department8,
            R.mipmap.img_new_department9,R.mipmap.img_new_department10
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        //初始化view
        initView();

        //初始化适配器
        initAdapter();

        selectdefult();

        initMyListViewListener();

        mbut_department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void selectdefult() {
        final int location = 0;
        myAdapter.setSelectedPosition(0);
        myAdapter.notifyDataSetInvalidated();

        subAdapter = new SubAdapter(getApplicationContext(),strs,0);
        subListView.setAdapter(subAdapter);
    }

    private void initMyListViewListener() {
        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int location = position;
                myAdapter.setSelectedPosition(position);
                myAdapter.notifyDataSetInvalidated();
                subAdapter = new SubAdapter(getApplicationContext(),strs,position);
                subListView.setAdapter(subAdapter);
            }
        });
    }


    private void initAdapter() {
        myAdapter = new MyAdapter(this,strss,images);
        mylistView.setAdapter(myAdapter);

    }

    //初始化view
    private void initView() {
        mylistView=(ListView) findViewById(R.id.mylistView);
        subListView=(ListView) findViewById(R.id.subListView);
        mbut_department = (Button) findViewById(R.id.but_department_back);
    }
}
