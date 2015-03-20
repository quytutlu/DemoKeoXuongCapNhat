package com.customlistview;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;

import com.customlistview.PullToRefreshListView.OnRefreshListener;

public class MainActivity extends ActionBarActivity {

	ArrayList<String> arrayList;
	ListViewCt adapter;
	Button bt;
	PullToRefreshListView lv;
	EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (PullToRefreshListView) findViewById(R.id.listrf);
		editText=(EditText) findViewById(R.id.editText1);
		lv.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				new GetDataTask().execute();
			}
		});
		arrayList = new ArrayList<String>();
		adapter = new ListViewCt(this, R.layout.listviewct, arrayList);
		lv.setAdapter(adapter);
		arrayList.add("tu");
		adapter.notifyDataSetChanged();
		Init();
	}

	private void Init() {
//		bt = (Button) findViewById(R.id.button1);
//		bt.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				String k = "quytutlu";
//				arrayList.add(k);
//				adapter.notifyDataSetChanged();
//			}
//		});

	}

	private class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected String[] doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
			return mStrings;
		}

		@Override
		protected void onPostExecute(String[] result) {
			lv.onRefreshComplete();
			arrayList.remove(0);
			arrayList.add(editText.getText().toString());
			adapter.notifyDataSetChanged();
			super.onPostExecute(result);
		}
	}

	private String[] mStrings = { "Andaman and Nicobar Islands",
			"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
			"Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh",
			"Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala",
			"Madhya Pradesh", "Maharashtra", "Manipur" };

}
