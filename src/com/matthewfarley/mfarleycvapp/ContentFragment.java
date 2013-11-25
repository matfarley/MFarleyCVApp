package com.matthewfarley.mfarleycvapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContentFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		super.onCreateView(inflater, parent, savedInstanceState);
		HomeScreenFragment.LayoutFlag flag = 
				(HomeScreenFragment.LayoutFlag)getActivity().getIntent().getExtras()
				.get(HomeScreenFragment.EXTRA_ENUM_LAYOUTFLAG);
		
		int layout = 0;
	    
		switch(flag){
	        case Skills:
	        	layout = getActivity().getIntent().getExtras().getInt(HomeScreenFragment.EXTRA_LAYOUT_SKILLS);
	        	break;
	        case WorkExperience:
	        	layout = getActivity().getIntent().getExtras().getInt(HomeScreenFragment.EXTRA_LAYOUT_WORK_EXPERIENCE);
	        	break;
	        case Education:
	        	layout = getActivity().getIntent().getExtras().getInt(HomeScreenFragment.EXTRA_LAYOUT_EDUCATION);
	        	break;
	        case Awards:
	        	layout = getActivity().getIntent().getExtras().getInt(HomeScreenFragment.EXTRA_LAYOUT_AWARDS);
	        	break;
	        	}
		if(layout != 0){
			View v = inflater.inflate(layout, parent, false);
			return v;
		}else{
			return null;
		}
	}

}
