package com.matthewfarley.mfarleycvapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class HomeScreenFragment extends Fragment {
	private static final String CONTACT_DIALOG = "dialog";
	RelativeLayout mSkillsRow;
	RelativeLayout mWorkExperienceRow;
	RelativeLayout mEducationRow;
	RelativeLayout mAwardsRow;
	RelativeLayout mContactRow;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		super.onCreateView(inflater, parent, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_home_screen, parent, false);
		
		
		//Write a reusable onClick listener
		
		//Using the Table row as a clickable button
		mSkillsRow = (RelativeLayout)v.findViewById(R.id.home_fragment_skillsRow);
		mSkillsRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Skills", Toast.LENGTH_SHORT).show(); // for testing
				
			}
		});
		
		mContactRow = (RelativeLayout)v.findViewById(R.id.home_fragment_contactRow);
		mContactRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity().getSupportFragmentManager();
				ContactDialogFragment dialog = new ContactDialogFragment();
				dialog.setTargetFragment(HomeScreenFragment.this,0);
				dialog.show(fm, CONTACT_DIALOG);
				
				
				
			}
		});
		
		
		return v;
	}

}
