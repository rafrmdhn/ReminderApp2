package com.example.projek_tam;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;

public class verified_activity extends Activity {

	
	private View _bg__verified;
	private View _rectangle_8;
	private TextView your_phone_has_been;
	private TextView verified;
	private View ellipse_2;
	private View ellipse_3;
	private ImageView vector;
	private View ellipse_1;
	private ImageView vector_ek1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.verified);

		
		_bg__verified = (View) findViewById(R.id._bg__verified);
		_rectangle_8 = (View) findViewById(R.id._rectangle_8);
		your_phone_has_been = (TextView) findViewById(R.id.your_phone_has_been);
		verified = (TextView) findViewById(R.id.verified2);
		ellipse_2 = (View) findViewById(R.id.ellipse_2);
		ellipse_3 = (View) findViewById(R.id.ellipse_3);
		vector = (ImageView) findViewById(R.id.vector);
		ellipse_1 = (View) findViewById(R.id.ellipse_1);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
	
		
		_rectangle_8.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), login_page_activity.class);
				startActivity(nextScreen);


			}
		});
		
		
		//custom code goes here
	
	}
}
	
	