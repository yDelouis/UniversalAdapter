UniversalAdapter
================

This small library aims to prevent Android developpers to write the same boring code for Adapters again and again.<br />
Indeed, for Adapters, Google suggest to use the ViewHolder pattern which leads to a very ugly code and a non reusable View.<br /><br />
This library proposes to change the goal of the Adapter. It's no longer a object which builds a View and set the data of the item in the View (calling setText(), setImage(), etc...). But it's a object which choose a View corresponding to an item and the View itself is responsible for binding the data of the item.<br /><br />
So you have an Adapter which do usually the same thing, so it can be created once and used for many of items and views. And you have Views which can be used for the adapter and in another part of your application.

How to use it ?
---------------

The steps to create a ListView using this library are :
1. Create a View and let it implement UAdaptable<I, V> where I is the class of the item to show and V the class of the view itself. 
2. Implement the two methods of UAdaptable :
  a. newInstance() which returns another View. In most of the cases you just have to call the constructor of the View.
  b. bind(I item) which is where you set the data of the item in the View.
3. Instantiate a UArrayAdapter in your Activity/Fragment passing to it the Context, your data, and an instance of the View.

Example :
---------
