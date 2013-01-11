package fr.ydelouis.universaladapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public class ULinearLayout<I> extends LinearLayout implements UAdaptable<I, ULinearLayout<I>>
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
	public ULinearLayout<I> newInstance() {
		return new ULinearLayout<I>(getContext(), layoutId);
	}

	@Override
	public void bind(int position, I item) {}
}
