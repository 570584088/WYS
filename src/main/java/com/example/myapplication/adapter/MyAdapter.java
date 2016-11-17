package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyAdapter extends BaseAdapter {

	Context context;
	LayoutInflater inflater;
	String [] strss;
	int last_item;
	int [] images;
	private int selectedPosition = -1;
	public MyAdapter(Context context,String [] strss,int[] images){
		this.context = context;
		this.strss = strss;
		this.images = images;

		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return strss.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder  holder = null;
	    if(convertView==null){
	    	convertView = inflater.inflate(R.layout.mylist_item, parent,false);
	    	holder = new ViewHolder();

        	holder.textView =(TextView)convertView.findViewById(R.id.textview);
        	holder.imageView1 =(ImageView)convertView.findViewById(R.id.imageview1_depart);
			holder.layout = (RelativeLayout) convertView.findViewById(R.id.mylist);
			holder.imageView2 = (ImageView) convertView.findViewById(R.id.imageview2_depart);

			convertView.setTag(holder);
	    }
	    else{
	    	holder=(ViewHolder)convertView.getTag();
	    }

		if (selectedPosition == position){
			holder.textView.setTextColor(Color.GREEN);
			holder.imageView2.setBackgroundResource(R.mipmap.img_inspectiondepartments2);
		}else{
			holder.textView.setTextColor(Color.BLACK);
			holder.imageView2.setBackgroundResource(R.mipmap.img_inspectiondepartments1);
		}


	    holder.textView.setText(strss[position]);
	  //  holder.textView.setTextColor(Color.BLACK);
	    holder.imageView1.setBackgroundResource(images[position]);

		return convertView;
	}


	public static class ViewHolder{
		 TextView textView;
		 ImageView  imageView1;
		 RelativeLayout layout;
		 ImageView imageView2;
	}

	public void setSelectedPosition(int position) {
		selectedPosition = position;
	}

}
