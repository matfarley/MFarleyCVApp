package com.matthewfarley.mfarleycvapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;

/**
 * @author matthewfarley
 * The app's main activity. Implements the abstract method createFragment()
 * to return an instance of the HomeScreenFragment 
 *
 */
public class HomeScreenActivity extends SingleFragmentActivity {
	
	@Override
	protected Fragment createFragment(){
		return new HomeScreenFragment();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
	}



}
