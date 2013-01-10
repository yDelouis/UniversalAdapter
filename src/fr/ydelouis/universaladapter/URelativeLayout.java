package fr.ydelouis.universaladapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

public class URelativeLayout<T> extends RelativeLayout implements UAdaptable<T, URelativeLayout<T>>
{
	private int layoutId;
	
	public URelativeLayout(Context context) {
		super(context);
	}
	
	public URelativeLayout(Context context, int layoutId) {
		super(context);
		if(layoutId != 0)
			View.inflate(context, layoutId, this);
	}
	
	@Override
	public URelativeLayout<T> newInstance() {
		return new URelativeLayout<T>(getContext(), layoutId);
	}

	@Override
	public void bind(int position, T item) {}
}
