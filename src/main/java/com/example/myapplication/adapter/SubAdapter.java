package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;


public class SubAdapter extends BaseAdapter {
	
	Context context;
	LayoutInflater layoutInflater;
	String[][] strs;
	public int strspoition;

	public SubAdapter(Context context, String[][] strs,int position) {
		this.context = context;
		this.strs = strs;
		layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		this.strspoition = position;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return strs[strspoition].length;
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return getItem(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		final int location=position;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.sublist_item, parent,false);
			viewHolder = new ViewHolder();
			viewHolder.textView = (TextView) convertView.findViewById(R.id.textview1);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.textView.setText(strs[strspoition][position]);
		viewHolder.textView.setTextColor(Color.BLACK);
		
		return convertView;
	}

	public static class ViewHolder {
		public TextView textView;
	}

}
