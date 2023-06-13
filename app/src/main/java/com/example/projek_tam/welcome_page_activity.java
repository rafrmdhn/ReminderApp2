package com.example.projek_tam;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.content.Intent;
import android.widget.ImageView;

public class welcome_page_activity extends Activity {

	
	private View __bg__welcome_page;
	private ImageView akoto_1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_page);

		
		__bg__welcome_page = (View) findViewById(R.id.__bg__welcome_page);
		akoto_1 = (ImageView) findViewById(R.id.akoto_1);
	
		
		__bg__welcome_page.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), login_page_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	