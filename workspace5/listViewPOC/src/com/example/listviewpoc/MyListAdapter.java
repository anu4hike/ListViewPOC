package com.example.listviewpoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter{
	
	private static final int STRING_ONLY = 0;
	
	private static final int IMAGE_ONLY = 1;

	private static final int MIXED_ROW = 2;
	
	private static final int VIEW_TYPE_COUNT = 3;
	
	private final Context context;
	private ArrayList<Object> list = new ArrayList<Object>();
	Random r = new Random();
	
	public MyListAdapter(Context context, List<Object> objects) {
		super();
		this.context = context;
		this.list = (ArrayList<Object>)objects;
	}

	static class ViewHolder
	{
		TextView text;
		ImageView icon;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Log.d("anu", "In getView, position : " + position);
		View view = convertView;
		int type = getItemViewType(position);
		ViewHolder holder = null;
		if (view == null)
		{
			Log.d("anu", "new view inflated");
//			Inflate the layout according to the viewType
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			holder = new ViewHolder();

			switch(type)
			{
			case STRING_ONLY:
				view = inflater.inflate(R.layout.list_item_textview, parent, false);
				holder.text = (TextView) view.findViewById(R.id.listitem_tv);
				break;
			case IMAGE_ONLY:
				view = inflater.inflate(R.layout.list_item_imageview, parent, false);
				holder.icon = (ImageView) view.findViewById(R.id.listitem_iv);
				break;
			case MIXED_ROW:
				view = inflater.inflate(R.layout.list_item_mixed, parent, false);
				holder.text = (TextView) view.findViewById(R.id.listitem_tv);
				holder.icon = (ImageView) view.findViewById(R.id.listitem_iv);
				break;
			}
			
			view.setTag(holder);
		}
		else
		{
			Log.d("anu", "using recycled view");
			holder = (ViewHolder) view.getTag();
		}
		
		Object item = list.get(position);

		switch(type)
		{
		case STRING_ONLY:
			TextView heading = (TextView) view.findViewById(R.id.listitem_tv);
			heading.setText((String)item + " Viewtype : " + getItemViewType(position));
			break;
		case MIXED_ROW:
			TextView tv = (TextView) view.findViewById(R.id.listitem_tv);
			Pair<String, Integer> p = (Pair<String, Integer>) item;
			tv.setText(p.first + " Viewtype : " + getItemViewType(position));
			break;
		}
		
		return view;
	}
	
	@Override
	public int getCount() {
//		Log.d("anu", "List Size : " + list.size());
		return list.size();
	}
	
	@Override
	public int getViewTypeCount() {
		return VIEW_TYPE_COUNT;
	}
	
	@Override
	public int getItemViewType(int position) {
		Log.d("anu", "Inside getItemViewType");
		Log.d("anu", "Position : " + position + ", Item : " + getItem(position));
		if (getItem(position) instanceof String)
		{
			return STRING_ONLY;
		}
		else if (getItem(position) instanceof Integer)
		{
			return IMAGE_ONLY;
		}
		else
		{
			return MIXED_ROW;
		}
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}
}
