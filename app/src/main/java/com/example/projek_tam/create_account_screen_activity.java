package com.example.projek_tam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class create_account_screen_activity extends Activity {

	
	private View _bg__create_account_screen;
	private View rectangle_3;
	private TextView username_ek1;
	private View rectangle_4;
	private TextView phone_number;
	private View rectangle_5;
	private TextView password;
	private TextView create_your;
	private TextView account__today_;
	private TextView please_fill_in_your_correct_details_;
	private View rectangle_5_ek1;
	private TextView create_account;
	private View rectangle_5_ek2;
	private TextView continue_with_google;
	private TextView or;
	private ImageView vector;
	private View rectangle_5_ek3;
	private TextView sign_in_to_your_account;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_account_screen);

		
		_bg__create_account_screen = (View) findViewById(R.id._bg__create_account_screen);
		rectangle_3 = (View) findViewById(R.id.rectangle_3);
		username_ek1 = (TextView) findViewById(R.id.username_ek1);
		rectangle_4 = (View) findViewById(R.id.rectangle_4);
		phone_number = (TextView) findViewById(R.id.phone_number);
		rectangle_5 = (View) findViewById(R.id.rectangle_5);
		password = (TextView) findViewById(R.id.password);
		create_your = (TextView) findViewById(R.id.create_your);
		account__today_ = (TextView) findViewById(R.id.account__today_);
		please_fill_in_your_correct_details_ = (TextView) findViewById(R.id.please_fill_in_your_correct_details_);
		rectangle_5_ek1 = (View) findViewById(R.id.rectangle_5_ek1);
		create_account = (TextView) findViewById(R.id.create_account);
		rectangle_5_ek2 = (View) findViewById(R.id.rectangle_5_ek2);
		continue_with_google = (TextView) findViewById(R.id.continue_with_google);
		or = (TextView) findViewById(R.id.or);
		vector = (ImageView) findViewById(R.id.vector);
		rectangle_5_ek3 = (View) findViewById(R.id.rectangle_5_ek3);
		sign_in_to_your_account = (TextView) findViewById(R.id.sign_in_to_your_account);


		create_account.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), verified_activity.class);
				startActivity(nextScreen);


			}
		});
	
	}
}
	
	