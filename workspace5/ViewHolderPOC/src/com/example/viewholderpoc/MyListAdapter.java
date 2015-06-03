package com.example.viewholderpoc;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter{

	private final Context context;
	private ArrayList<Object> list = new ArrayList<Object>();
	
	private final boolean viewHolderMode = true;
	
	public MyListAdapter(Context context, List<Object> objects) {
		super();
		this.context = context;
		this.list = (ArrayList<Object>)objects;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Long t1 = System.currentTimeMillis();
		View view = convertView;
		ViewHolder holder = null;
		
		if (viewHolderMode)
		{
			if (view == null)
			{
				holder = new ViewHolder();
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.list_item, parent, false);
				holder.text1 = (TextView) view.findViewById(R.id.listitem_tv1);
				holder.image1 = (ImageView) view.findViewById(R.id.listitem_iv);
				holder.text2 = (TextView) view.findViewById(R.id.listitem_tv2);
				holder.text3 = (TextView) view.findViewById(R.id.listitem_tv3);
				holder.image2 = (ImageView) view.findViewById(R.id.listitem_iv2);
				view.setTag(holder);
			}
			else
			{
				holder = (ViewHolder) view.getTag();
			}
			
			ArrayList<String> item = (ArrayList<String>) list.get(position);
			
			holder.text1.setText(item.get(0));
			holder.image1.setImageResource(R.drawable.ic_launcher);
			holder.text2.setText(item.get(1));
			holder.text3.setText(item.get(2));
			holder.image2.setImageResource(R.drawable.ic_launcher);
		}
		else
		{
			if (view == null)
			{
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.list_item, parent, false);
			}
			
			ArrayList<String> item = (ArrayList<String>) list.get(position);
			
			TextView text1 = (TextView) view.findViewById(R.id.listitem_tv1);
			ImageView image1 = (ImageView) view.findViewById(R.id.listitem_iv);
			TextView text2 = (TextView) view.findViewById(R.id.listitem_tv2);
			TextView text3 = (TextView) view.findViewById(R.id.listitem_tv3);
			ImageView image2 = (ImageView) view.findViewById(R.id.listitem_iv2);
			text1.setText(item.get(0));
			image1.setImageResource(R.drawable.ic_launcher);
			text2.setText(item.get(1));
			text3.setText(item.get(2));
			image2.setImageResource(R.drawable.ic_launcher);
		}
		
		Log.d("anu", "Time : " + (System.currentTimeMillis() - t1));
		return view;
	}
	
	static class ViewHolder
	{
		TextView text1;
		ImageView image1;
		TextView text2;
		TextView text3;
		ImageView image2;
	}
}
