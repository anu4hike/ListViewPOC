package com.example.listviewpoc;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

	private Button add_btn_notify;
	private Button add_btn_not_notify;
	private Button remove_btn_notify;
	private Button remove_btn_not_notify;
	
	private EditText editTxt;
	
	private ListView list;
	private MyListAdapter myListAdapter;
	
	private ArrayList<Object> arrayList;
	
	private static final int ROW_TYPES = 3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Random r = new Random();

        add_btn_notify = (Button) findViewById(R.id.add_button_notify);
        add_btn_not_notify = (Button) findViewById(R.id.add_button_not_notify);
        remove_btn_notify = (Button) findViewById(R.id.remove_button_notify);
        remove_btn_not_notify = (Button) findViewById(R.id.remove_button_not_notify);
        
        editTxt = (EditText) findViewById(R.id.edittext);

        list = (ListView) findViewById(R.id.list);
        
        arrayList = new ArrayList<Object>();
//        arrayList = new ArrayList<String>(Arrays.asList(values));
        
//        list.post(new Runnable()
//        {
//            public void run()
//            {
//                list.setSelection(arrayList.size()-1);
//            }
//        });
        
        myListAdapter = new MyListAdapter(getApplicationContext(), arrayList);
        
        list.setAdapter(myListAdapter);
        
        add_btn_notify.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		        int i = (arrayList.size()==0?0:r.nextInt(arrayList.size()));
		        int viewType = r.nextInt(ROW_TYPES);
		        Log.d("anu", "Row_type : " + viewType);
		        switch(viewType)
		        {
		        case 0:
		        	arrayList.add(0, editTxt.getText().toString());
		        	break;
		        case 1:
		        	arrayList.add(0, R.drawable.ic_launcher);
		        	break;
		        case 2:
		        	Pair<String, Integer> p = new Pair<String, Integer>(editTxt.getText().toString(), R.drawable.ic_launcher);
		        	arrayList.add(0, p);
		        	break;
		        }
		        for (Object obj : arrayList) 
		        {
					Log.d("anu", "Item : " + obj);
				}
				myListAdapter.notifyDataSetChanged();
			}
		});
        
        add_btn_not_notify.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		        int i = (arrayList.size()==0?0:r.nextInt(arrayList.size()));
		        int viewType = r.nextInt(ROW_TYPES);
		        Log.d("anu", "Row_type : " + viewType);
		        switch(viewType)
		        {
		        case 0:
		        	arrayList.add(0, editTxt.getText().toString());
		        	break;
		        case 1:
		        	arrayList.add(0, R.drawable.ic_launcher);
		        	break;
		        case 2:
		        	Pair<String, Integer> p = new Pair<String, Integer>(editTxt.getText().toString(), R.drawable.ic_launcher);
		        	arrayList.add(0, p);
		        	break;
		        }
		        for (Object obj : arrayList) 
		        {
					Log.d("anu", "Item : " + obj);
				}
			}
		});
        
        remove_btn_notify.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		        int i = (arrayList.size()==0?0:r.nextInt(arrayList.size()));
				arrayList.remove(arrayList.size()-1);
				myListAdapter.notifyDataSetChanged();
			}
		});
        
        remove_btn_not_notify.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		        int i = (arrayList.size()==0?0:r.nextInt(arrayList.size()));
				arrayList.remove(arrayList.size()-1);
			}
		});
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
