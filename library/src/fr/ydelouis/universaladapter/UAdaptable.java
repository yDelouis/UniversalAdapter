package fr.ydelouis.universaladapter;

import android.widget.Adapter;

/**
 * Interface implemented by a View which shows an item
 * in a ListView or a GridVIew
 * 
 * @author yDelouis
 *
 * @param <I> Class
 * @param <V>
 */
public interface UAdaptable<I, V extends UAdaptable<I, V>>
{
	public void bind(int position, I item, Adapter adapter);
	public V newInstance();
}
