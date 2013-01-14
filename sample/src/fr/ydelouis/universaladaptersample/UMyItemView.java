package fr.ydelouis.universaladaptersample;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.ydelouis.universaladapter.UAdaptable;

public class UMyItemView extends LinearLayout implements UAdaptable<String, UMyItemView>
{
	private TextView	text;
	private ImageView	image1;
	private ImageView	image2;
	private int			nbImages;
	
	public UMyItemView(Context context) {
		super(context);
		init();
	}
	
	private void init() {
		View.inflate(getContext(), R.layout.myitemview, this);
		text = (TextView) findViewById(R.id.myItemView_text);
		image1 = (ImageView) findViewById(R.id.myItemView_image1);
		image2 = (ImageView) findViewById(R.id.myItemView_image2);
		nbImages = android.R.drawable.ic_menu_zoom - android.R.drawable.ic_menu_add;
	}

	@Override
	public void bind(int position, String item) {
		text.setText(item);
		image1.setImageResource(android.R.drawable.ic_menu_add + (position % nbImages));
		image2.setImageResource(android.R.drawable.ic_menu_add + ((position + nbImages / 2) % nbImages));
	}

	@Override
	public UMyItemView newInstance() {
		return new UMyItemView(getContext());
	}
}
