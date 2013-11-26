package com.matthewfarley.mfarleycvapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContentFragment extends Fragment {
	
	/**
	 * static method is used to attach the arguments to the args bundle
	 * and the args bundle to the to the new ContentFragment before it
	 * is attached to its host activity.
	 */
	public static ContentFragment newInstance(int layout){
		Bundle args = new Bundle();
		args.putInt(HomeScreenFragment.EXTRA_LAYOUT, layout);
		
		ContentFragment fragment = new ContentFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		super.onCreateView(inflater, parent, savedInstanceState);
		
		int layout = getArguments().getInt(HomeScreenFragment.EXTRA_LAYOUT);

		//0 is the default value of the extra carrying the layout value.
		if(layout != 0){
			View v = inflater.inflate(layout, parent, false);
			return v;
		}else{
			return null;
		}
	}

}
