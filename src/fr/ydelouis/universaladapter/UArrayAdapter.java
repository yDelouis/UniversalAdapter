package fr.ydelouis.universaladapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class UArrayAdapter<T, U extends View & UAdaptable<T, U>> extends ArrayAdapter<T>
{
	private U example;

	public UArrayAdapter(Context context, T[] data, U example) {
		super(context, 0, data);
		this.example = example;
	}
	
	public UArrayAdapter(Context context, List<T> data, U example) {
		super(context, 0, data);
		this.example = example;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if(view == null)
			view = example.newInstance();
		
		((U) view).bind(position, getItem(position));
		return view;
	}
}
