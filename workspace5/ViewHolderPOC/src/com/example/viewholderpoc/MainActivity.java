package com.example.viewholderpoc;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	private ListView list;
	private MyListAdapter myListAdapter;
	private ArrayList<Object> arrayList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        list = (ListView) findViewById(R.id.list);
        arrayList = new ArrayList<Object>();
    	ArrayList<String> aList = new ArrayList<String>();
        for (int i=0; i<100000; i++)
        {
        	aList.add("Item : " + i);
        	aList.add("a");
        	aList.add("b");
        	arrayList.add(aList);
        }
        
        myListAdapter = new MyListAdapter(getApplicationContext(), arrayList);
        list.setAdapter(myListAdapter);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
