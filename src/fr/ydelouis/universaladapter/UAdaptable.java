package fr.ydelouis.universaladapter;


public interface UAdaptable<T, U extends UAdaptable<T, U>>
{
	public void bind(int position, T item);
	public U newInstance();
}
