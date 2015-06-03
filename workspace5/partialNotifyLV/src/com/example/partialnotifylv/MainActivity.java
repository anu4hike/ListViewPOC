package com.example.partialnotifylv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private ArrayList<String> arrayList;
	private ListView listView;
	private MyListAdapter myListAdapter;
	private String[] values;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		values = new String[] { "item0", "item1", "item2", "item3", "item4",
				"item5", "item6", "item7", "item8", "item9", "item10",
				"item11", "item12", "item13", "item14", "item15", "item16",
				"item17", "item18", "item19", "item20" };
		arrayList = new ArrayList<String>(Arrays.asList(values));
		listView = (ListView) findViewById(R.id.list);
		myListAdapter = new MyListAdapter(getApplicationContext(), arrayList, listView);
		listView.setAdapter(myListAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.modify) {
			Random r = new Random();
			final int num = r.nextInt(arrayList.size());
			Log.d("anu", "Item modified : " + num);
			arrayList.set(num, "item modified");
//			listView.post(new Runnable()
//	        {
//	            public void run()
//	            {
//	                listView.setSelection(num);
//	            }
//	        });
			View child = listView.getChildAt(num);
//			View child = listView.getChildAt(num-listView.getFirstVisiblePosition());
			if (child.isShown())
			{
				TextView childView = (TextView) child.findViewById(R.id.list_item);
				childView.setText(arrayList.get(num));
			}
		}
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
