package fr.ydelouis.universaladapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class UArrayAdapter<I, V extends View & UAdaptable<I, V>> extends ArrayAdapter<I>
{
	private V example;

	public UArrayAdapter(Context context, I[] data, V example) {
		super(context, 0, data);
		this.example = example;
	}
	
	public UArrayAdapter(Context context, List<I> data, V example) {
		super(context, 0, data);
		this.example = example;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if(view == null || !(view instanceof V))
			view = example.newInstance();
		
		((V) view).bind(position, getItem(position));
		return view;
	}
}
