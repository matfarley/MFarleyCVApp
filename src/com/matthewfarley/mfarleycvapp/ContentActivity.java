package com.matthewfarley.mfarleycvapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;

public class ContentActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new ContentFragment();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void finish(){
		super.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
	}

}
