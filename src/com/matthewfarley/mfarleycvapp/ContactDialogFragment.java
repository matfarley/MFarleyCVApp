package com.matthewfarley.mfarleycvapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * @author matthewfarley
 * Fragment is used to send implicit intents out to the call, email or visit 
 * my github.
 */
public class ContactDialogFragment extends DialogFragment {
	private static final String PHONE_NUMBER = "+64220672197";
	private static final String[] EMAIL_ADDRESS = new String[]{"matfarley@gmail.com"};
	private static final String GITHUB_URL = "https://github.com/matfarley";
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		super.onCreateDialog(savedInstanceState);;
		
		//inflate view
		View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_contact, null);

		
		//Wire up the buttons/Relative Views
		RelativeLayout callMobile = (RelativeLayout)v.findViewById(R.id.contact_dialog_call);
		callMobile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + PHONE_NUMBER));
				i = Intent.createChooser(i, "Call Mobile");
				startActivity(i);
				
			}
		});
		
		RelativeLayout sendEmail = (RelativeLayout)v.findViewById(R.id.contact_dialog_email);
		sendEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_EMAIL, EMAIL_ADDRESS);
				i = Intent.createChooser(i, "Send Email");
				startActivity(i);

			}
		});
		
		RelativeLayout visitGitHub = (RelativeLayout)v.findViewById(R.id.contact_dialog_git);
		visitGitHub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_URL));
				i = Intent.createChooser(i, "Open GitHub Page");
				startActivity(i);
				
			}
		});
		
		//build the alert dialog
		ContextThemeWrapper context = new ContextThemeWrapper(getActivity(), R.style.AppTheme);
		return new AlertDialog.Builder(context)
				.setView(v)
				.create();
	}
	

}
