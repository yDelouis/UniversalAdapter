package fr.ydelouis.universaladapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

public class URelativeLayout<I> extends RelativeLayout implements UAdaptable<I, URelativeLayout<I>>
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
	public URelativeLayout<I> newInstance() {
		return new URelativeLayout<I>(getContext(), layoutId);
	}

	@Override
	public void bind(int position, I item) {}
}
