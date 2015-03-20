package com.customlistview;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressLint("ViewHolder")
public class ListViewCt extends ArrayAdapter<String> {

	private Context context;
	@SuppressWarnings("unused")
	private int layoutId;
	ArrayList<String> arrTopics;

	public ListViewCt(Context context, int layoutId, ArrayList<String> arrTopics) {
		super(context, layoutId,arrTopics);
		this.context = context;
		this.layoutId = layoutId;
		this.arrTopics = arrTopics;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.listviewct, parent, false);
		TextView textView=(TextView) rowView.findViewById(R.id.textView1);
		textView.setText(arrTopics.get(position));
		return rowView;
	}
}
