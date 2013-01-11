package fr.ydelouis.universaladapter;


public interface UAdaptable<I, V extends UAdaptable<I, V>>
{
	public void bind(int position, I item);
	public V newInstance();
}
