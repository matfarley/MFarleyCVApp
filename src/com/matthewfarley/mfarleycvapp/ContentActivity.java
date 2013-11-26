package com.matthewfarley.mfarleycvapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;

public class ContentActivity extends SingleFragmentActivity {

	/**
	 * the implementation of this method gets the extras from the intent and
	 * passes them into the fragments static newInstance() method which is used
	 * to add the parameters to the args list when creating the new ContentFragment
	 */
	@Override
	protected Fragment createFragment() {
		int layout = getIntent().getIntExtra(HomeScreenFragment.EXTRA_LAYOUT, 0);
		return ContentFragment.newInstance(layout);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		}
	
	@Override
	public void finish(){
		//used to make sure the custom animation is used when the activity is killed.
		super.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
	}

}
