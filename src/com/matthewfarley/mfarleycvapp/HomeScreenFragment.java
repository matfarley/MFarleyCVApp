package com.matthewfarley.mfarleycvapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class HomeScreenFragment extends Fragment {
	//String key constant, used for sending an explicit intent to start the contact dialog fragment
	private static final String CONTACT_DIALOG = "dialog";
	//String key used as a key for the layout extra's sent to ContentActivity/Fragment
	public static final String EXTRA_LAYOUT = 
			"com.matthewfarley.mfarleycvapp.layout";
	RelativeLayout mSkillsRow;
	RelativeLayout mWorkExperienceRow;
	RelativeLayout mEducationRow;
	RelativeLayout mAwardsRow;
	RelativeLayout mContactRow;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		super.onCreateView(inflater, parent, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_home_screen, parent, false);

		//Using the RelativeLayout's as a clickable button
		mSkillsRow = (RelativeLayout)v.findViewById(R.id.home_fragment_skillsRow);
		mSkillsRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ContentActivity.class);
				i.putExtra(EXTRA_LAYOUT, R.layout.fragment_content_skills);
				startActivity(i);
			}
		});
		
		mWorkExperienceRow = (RelativeLayout)v.findViewById(R.id.home_fragment_workExperienceRow);
		mWorkExperienceRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ContentActivity.class);
				i.putExtra(EXTRA_LAYOUT, R.layout.fragment_content_work_experience);
				startActivity(i);	
			}
		});
		
		mEducationRow = (RelativeLayout)v.findViewById(R.id.home_fragment_educationRow);
		mEducationRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ContentActivity.class);
				i.putExtra(EXTRA_LAYOUT, R.layout.fragment_content_education);
				startActivity(i);
			}
		});
		
		mAwardsRow = (RelativeLayout)v.findViewById(R.id.home_fragment_awardsRow);
		mAwardsRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ContentActivity.class);
				i.putExtra(EXTRA_LAYOUT, R.layout.fragment_content_awards);
				startActivity(i);
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
