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
 * class
 *
 */
public abstract class SingleFragmentActivity extends FragmentActivity {
	
	protected abstract Fragment createFragment(); 
	
	protected int getLayoutResId(){
		return R.layout.activity_fragment;
	}
	
	
	/**
	 * takes care of finding and commiting the  fragment for the concrete child
	 * class that will implement this class
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
