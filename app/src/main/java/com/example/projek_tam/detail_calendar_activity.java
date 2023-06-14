package com.example.projek_tam;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class detail_calendar_activity extends Activity {

	
	private View _bg__detail_calendar;
	private ImageView rectangle_10;
	private TextView event_details;
	private TextView tgl_acara;
	private TextView alarm;
	private TextView notes;
	private View line_4;
	private TextView _edit;
	private TextView jumat_agung;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_calendar);

		
		_bg__detail_calendar = (View) findViewById(R.id._bg__detail_calendar);
		rectangle_10 = (ImageView) findViewById(R.id.rectangle_10);
		event_details = (TextView) findViewById(R.id.event_details);
		tgl_acara = (TextView) findViewById(R.id.tgl_acara);
		alarm = (TextView) findViewById(R.id.alarm);
		notes = (TextView) findViewById(R.id.notes);
		line_4 = (View) findViewById(R.id.line_4);
		_edit = (TextView) findViewById(R.id._edit);
		jumat_agung = (TextView) findViewById(R.id.jumat_agung);
	
		
		_edit.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), edit_events_activity.class);
				startActivity(nextScreen);


			}
		});

		Intent intent = getIntent();
		if (intent != null) {
			String selectedDay = intent.getStringExtra("selectedDay");
			String selectedMonthYear = intent.getStringExtra("selectedMonthYear");

			jumat_agung.setText(selectedDay);
		}



		//custom code goes here
	
	}
}
	
	