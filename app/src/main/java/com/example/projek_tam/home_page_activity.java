package com.example.projek_tam;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class home_page_activity extends Activity {

	
	private View _bg__home_page;
	private ImageView vector;
	private ImageView vector_ek1;
	private View rectangle_5;
	private View rectangle_6;
	private ImageView vector_ek2;
	private TextView my_day;
	private TextView calendar;
	private TextView all_tasks;
	private ImageView vector_ek3;
	private ImageView vector_ek4;
	private View rectangle_8;
	private ImageView vector_ek5;
	private TextView search_for_task__events__notes__etc__;
	private TextView easily_manage_your_team_s_work_with_project_boards__customized_workflows_and_integrations;
	private TextView my_list;
	private TextView workspace;
	private View grocery_kotak;
	private TextView grocery_list;
	private View work_kotak;
	private TextView work;
	private View _personal_kotak;
	private TextView personal;
	private View tambah_kotak;
	private ImageView vector_ek6;
	private ImageView vector_ek7;
	private View tambah_kotak_ek1;
	private ImageView vector_ek8;
	private ImageView vector_ek9;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);

		
		_bg__home_page = (View) findViewById(R.id._bg__home_page);
		vector = (ImageView) findViewById(R.id.vector);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		rectangle_5 = (View) findViewById(R.id.rectangle_5);
		rectangle_6 = (View) findViewById(R.id.rectangle_6);
		vector_ek2 = (ImageView) findViewById(R.id.vector_ek2);
		my_day = (TextView) findViewById(R.id.my_day);
		calendar = (TextView) findViewById(R.id.calendar);
		all_tasks = (TextView) findViewById(R.id.all_tasks);
		vector_ek3 = (ImageView) findViewById(R.id.vector_ek3);
		vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);
		rectangle_8 = (View) findViewById(R.id.rectangle_8);
		vector_ek5 = (ImageView) findViewById(R.id.vector_ek5);
		search_for_task__events__notes__etc__ = (TextView) findViewById(R.id.search_for_task__events__notes__etc__);
		easily_manage_your_team_s_work_with_project_boards__customized_workflows_and_integrations = (TextView) findViewById(R.id.easily_manage_your_team_s_work_with_project_boards__customized_workflows_and_integrations);
		my_list = (TextView) findViewById(R.id.my_list);
		workspace = (TextView) findViewById(R.id.workspace);
		grocery_kotak = (View) findViewById(R.id.grocery_kotak);
		grocery_list = (TextView) findViewById(R.id.grocery_list);
		work_kotak = (View) findViewById(R.id.work_kotak);
		work = (TextView) findViewById(R.id.work);
		_personal_kotak = (View) findViewById(R.id._personal_kotak);
		personal = (TextView) findViewById(R.id.personal);
		tambah_kotak = (View) findViewById(R.id.tambah_kotak);
		vector_ek6 = (ImageView) findViewById(R.id.vector_ek6);
		vector_ek7 = (ImageView) findViewById(R.id.vector_ek7);
		tambah_kotak_ek1 = (View) findViewById(R.id.tambah_kotak_ek1);
		vector_ek8 = (ImageView) findViewById(R.id.vector_ek8);
		vector_ek9 = (ImageView) findViewById(R.id.vector_ek9);
	
		
		all_tasks.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), all_tasks_page_activity.class);
				startActivity(nextScreen);
			}
		});

		vector_ek3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), all_tasks_page_activity.class);
				startActivity(nextScreen);
			}
		});

		calendar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), calendar.class);
				startActivity(nextScreen);
			}
		});

		//custom code goes here
	
	}
}

	
	