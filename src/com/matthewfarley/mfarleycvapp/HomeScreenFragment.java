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
	private static final String CONTACT_DIALOG = "dialog";
	public static final String EXTRA_ENUM_LAYOUTFLAG = 
			"com.matthewfarley.mfarleycvapp.enum.layoutflag";
	public static final String EXTRA_LAYOUT_SKILLS = 
			"com.matthewfarley.mfarleycvapp.skills";
	public static final String EXTRA_LAYOUT_WORK_EXPERIENCE = 
			"com.matthewfarley.mfarleycvapp.workexperience";
	public static final String EXTRA_LAYOUT_EDUCATION = 
			"com.matthewfarley.mfarleycvapp.education";
	public static final String EXTRA_LAYOUT_AWARDS = 
			"com.matthewfarley.mfarleycvapp.awards";
	RelativeLayout mSkillsRow;
	RelativeLayout mWorkExperienceRow;
	RelativeLayout mEducationRow;
	RelativeLayout mAwardsRow;
	RelativeLayout mContactRow;
	
	/**
	 * @author matthewfarley
	 * These flags are added to an intent along with a layout reference
	 * so that a switch statement can be used to select the appropriate
	 * layout to inflate.
	 */
	public enum LayoutFlag {Skills, WorkExperience, Education, Awards}
	
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
				Intent i = new Intent(getActivity(), ContentActivity.class);
				i.putExtra(EXTRA_ENUM_LAYOUTFLAG, LayoutFlag.Skills);
				i.putExtra(EXTRA_LAYOUT_SKILLS, R.layout.fragment_content_skills);
				startActivity(i);
			}
		});
		
		mWorkExperienceRow = (RelativeLayout)v.findViewById(R.id.home_fragment_workExperienceRow);
		mWorkExperienceRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ContentActivity.class);
				i.putExtra(EXTRA_ENUM_LAYOUTFLAG, LayoutFlag.WorkExperience);
				i.putExtra(EXTRA_LAYOUT_WORK_EXPERIENCE, R.layout.fragment_content_work_experience);
				startActivity(i);	
			}
		});
		
		mEducationRow = (RelativeLayout)v.findViewById(R.id.home_fragment_educationRow);
		mEducationRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ContentActivity.class);
				i.putExtra(EXTRA_ENUM_LAYOUTFLAG, LayoutFlag.Education);
				i.putExtra(EXTRA_LAYOUT_EDUCATION, R.layout.fragment_content_education);
				startActivity(i);
			}
		});
		
		mAwardsRow = (RelativeLayout)v.findViewById(R.id.home_fragment_awardsRow);
		mAwardsRow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ContentActivity.class);
				i.putExtra(EXTRA_ENUM_LAYOUTFLAG, LayoutFlag.Awards);
				i.putExtra(EXTRA_LAYOUT_AWARDS, R.layout.fragment_content_awards);
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
