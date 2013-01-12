UniversalAdapter
================

This small library aims to prevent Android developpers from writing the same boring code for Adapters again and again.<br />
Indeed, for Adapters, Google suggest to use the ViewHolder pattern which leads to a very ugly code and a non reusable View.<br /><br />
This library proposes to change the goal of the Adapter. It's no longer an object which builds a View and set the data of the item in the View (calling setText(), setImage(), etc...). But it's an object which chooses a View corresponding to an item and the View itself is responsible for binding the data of the item.<br /><br />
So you have an Adapter which usually do the same thing, so it can be written once (in the library) and used for many items and views. And you have some reusable Views which can be used for a `ListVIew` and in other parts of your application.

How to use it ?
---------------

The steps to create a `ListView` using this library are :<br />
1. Create a `View` and let it implement `UAdaptable<I, V>` where `I` is the class of the item to show and `V` the class of the view itself.<br />
2. Implement the two methods of `UAdaptable` :<br />
  a. `newInstance()` which returns another `View`. In most of the cases you just have to call the constructor of the View.<br />
  b. `bind(I item)` which is where you set the data of the item in the `View`.<br />
3. Instantiate a `UArrayAdapter<I, V>` in your `Activity`/`Fragment` passing to it the `Context`, a `List` of items, and an instance of the `View`.

Example :
---------
1. The `View` which shows an instance of `MyItem`
```java

    public class MyItemView extends LinearLayout implements UAdaptable<MyItem, UMyItemView>
    {
        private TextView  text;
        private ImageView image;
    
        public MyItemView(Context context) {
            super(context);
            init();
        }
    
        private void init() {
            View.inflate(getContext(), R.layout.myitemview, this);
            text = (TextView) findViewById(R.id.myitemview_text);
            image = (ImageView) findViewById(R.id.myitemview_image);
        }
    
        @Override
        public void bind(int position, MyItem item) {
            text.setText(item.getText());
            image.setImageResource(item.getImageResource());
        }
    
        @Override
        public MyItemView newInstance() {
            return new MyItemView(getContext());
        }
    }
```

2. The `Activity`/`Fragment` (`ctx` represents the `Context`)
```java

    UArrayAdapter<MyItem, MyItemView> adapter = new UArrayAdapter<MyItem, MyItemView>(ctx, items, new MyItemView(ctx));
    listView.setAdapter(adapter);
    
``` 
