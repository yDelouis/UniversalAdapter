package fr.ydelouis.universaladaptersample;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import fr.ydelouis.universaladapter.UArrayAdapter;

public class UAADemoActivity extends ListActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(android.R.layout.list_content);
		getListView().setAdapter(new UArrayAdapter<String, MyItemView>(this, createData(), new MyItemView(this)));
	}

	private List<String> createData() {
		List<String> data = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i < 366; i++) {
			cal.set(Calendar.DAY_OF_YEAR, 0);
			data.add(cal.toString());
		}
		return data;
	}
}
