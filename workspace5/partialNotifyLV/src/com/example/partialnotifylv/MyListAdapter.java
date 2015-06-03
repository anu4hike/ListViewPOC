/**
 * 
 */
package com.example.partialnotifylv;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author anubansal
 *
 */
public class MyListAdapter extends BaseAdapter{
	
	private Context context;
	private ArrayList<String> arrayList = new ArrayList<String>();
	private ListView listView;
	
	public MyListAdapter(Context context, List<String> list, ListView listView)
	{
		super();
		this.context = context;
		this.arrayList = (ArrayList<String>) list;
		this.listView = listView;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null)
		{
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_item, parent, false);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.list_item);
		tv.setText(arrayList.get(position));
		return convertView;
	}

	@Override
	public int getCount() {
		return arrayList.size();
	}

	@Override
	public Object getItem(int position) {
		return arrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public void notifyDataSetInvalidated() {
		// TODO Auto-generated method stub
		super.notifyDataSetInvalidated();
	}
}
