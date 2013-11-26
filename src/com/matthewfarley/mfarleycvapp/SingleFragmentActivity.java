package com.matthewfarley.mfarleycvapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
/**
 * @author matthewfarley
 * 
 * Abstract class used to create a standard activity with methods that will 
 * create and return a fragment to be displayed in the concrete implementing
 * class. References a layout that has an empty frame lout to host the fragments
 * views.
 *
 */
public abstract class SingleFragmentActivity extends FragmentActivity {
	
	/**
	 * To be implemented in a child class when the concrete type of fragment 
	 * this method is returning is known
	 */
	protected abstract Fragment createFragment(); 
	
	//getting the layout which will host the fragments view
	protected int getLayoutResId(){
		return R.layout.activity_fragment;
	}
	
	
	/**
	 * takes care of finding and committing the hosted fragment for the concrete child
	 * class that will extend this class.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResId());
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		if(fragment == null){
			fragment = createFragment();
			fm.beginTransaction()
			    .add(R.id.fragmentContainer, fragment)
			    .commit();
		}
	}

}
