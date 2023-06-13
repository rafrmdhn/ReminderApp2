package com.example.projek_tam;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class all_tasks_page_activity extends Activity {

	
	private View _bg__all_tasks_page;
	private View rectangle_7;
	private View ellipse_1;
	private ImageView vector;
	private ImageView vector_ek1;
	private ImageView vector_ek2;
	private TextView all_tasks;
	private TextView _today;
	private ImageView vector_ek3;
	private ImageView vector_ek4;
	private ImageView vector_ek5;
	private ImageView vector_ek6;
	private ImageView vector_ek7;
	private ImageView vector_ek8;
	private ImageView vector_ek9;
	private ImageView vector_ek10;
	private TextView _tomorrow;
	private TextView _upcomming;
	private TextView _someday;
	private View rectangle_5;
	private View _rectangle_6;
	private ImageView _vector_ek11;
	private TextView i_want____;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_tasks_page);

		
		_bg__all_tasks_page = (View) findViewById(R.id._bg__all_tasks_page);
		rectangle_7 = (View) findViewById(R.id.rectangle_7);
		ellipse_1 = (View) findViewById(R.id.ellipse_1);
		vector = (ImageView) findViewById(R.id.vector);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		vector_ek2 = (ImageView) findViewById(R.id.vector_ek2);
		all_tasks = (TextView) findViewById(R.id.all_tasks);
		_today = (TextView) findViewById(R.id._today);
		vector_ek3 = (ImageView) findViewById(R.id.vector_ek3);
		vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);
		vector_ek5 = (ImageView) findViewById(R.id.vector_ek5);
		vector_ek6 = (ImageView) findViewById(R.id.vector_ek6);
		vector_ek7 = (ImageView) findViewById(R.id.vector_ek7);
		vector_ek8 = (ImageView) findViewById(R.id.vector_ek8);
		vector_ek9 = (ImageView) findViewById(R.id.vector_ek9);
		vector_ek10 = (ImageView) findViewById(R.id.vector_ek10);
		_tomorrow = (TextView) findViewById(R.id._tomorrow);
		_upcomming = (TextView) findViewById(R.id._upcomming);
		_someday = (TextView) findViewById(R.id._someday);
		rectangle_5 = (View) findViewById(R.id.rectangle_5);
		_rectangle_6 = (View) findViewById(R.id._rectangle_6);
		_vector_ek11 = (ImageView) findViewById(R.id._vector_ek11);
		i_want____ = (TextView) findViewById(R.id.i_want____);
	
		
//		_today.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), all_tasks_page_2_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//
//
//		_tomorrow.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), all_tasks_page_2_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//
//
//		_upcomming.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), all_tasks_page_2_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//
//
//		_someday.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), all_tasks_page_2_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//
//
//		_rectangle_6.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), all_tasks_page_2_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//
//
		_vector_ek11.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), home_page_activity.class);
				startActivity(nextScreen);


			}
		});
		
		//custom code goes here
	
	}
}
	
	