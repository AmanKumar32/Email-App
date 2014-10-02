package com.felight.emailapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EmailActivity extends Activity {

	Button btncompose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		btncompose = (Button) findViewById(R.id.btncompose);
		btncompose.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sendEmail();
			}
		});
	}

	protected void sendEmail() {
		String[] TO = { "ampathania32@gmail.com" };
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.setType("text/plain");

		emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
		emailIntent.putExtra(Intent.EXTRA_TEXT, "Type Your Message Here::");
		try {
			startActivity(Intent.createChooser(emailIntent, "Send Mail"));
			finish();

		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(getBaseContext(), "No Mail Client Is Present",
					Toast.LENGTH_SHORT).show();

		}
	}

}
