package fr.ydelouis.universaladapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public class ULinearLayout<T> extends LinearLayout implements UAdaptable<T, ULinearLayout<T>>
{
	private int layoutId;
	
	public ULinearLayout(Context context) {
		super(context);
	}
	
	public ULinearLayout(Context context, int layoutId) {
		super(context);
		if(layoutId != 0)
			View.inflate(context, layoutId, this);
	}
	
	@Override
	public ULinearLayout<T> newInstance() {
		return new ULinearLayout<T>(getContext(), layoutId);
	}

	@Override
	public void bind(int position, T item) {}
}
