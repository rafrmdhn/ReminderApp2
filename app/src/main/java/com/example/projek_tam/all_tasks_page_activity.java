package com.example.projek_tam;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

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

	private RecyclerView rViewToday;

	private all_taskAdapter atAdapter;
	private List<TaskObject> allTask;


	private FirebaseFirestore db;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_tasks_page);

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

		allTask = new ArrayList<>();
		atAdapter = new all_taskAdapter(allTask);
		rViewToday = findViewById(R.id.today_tasks);
		rViewToday.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		rViewToday.setAdapter(atAdapter);

		db = FirebaseFirestore.getInstance();
		CollectionReference verifRef = db.collection("Calendar");
		Query query = verifRef.whereEqualTo("Tanggal", "17 June 2023");

		query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
					@Override
					public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
						List<TaskObject> taskList = new ArrayList<>();

						for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
							String acara = documentSnapshot.getString("Acara");

							TaskObject to = new TaskObject(acara);
							taskList.add(to);
						}

						// Update the adapter with the retrieved product list
						atAdapter.setTaskList(taskList);
						atAdapter.notifyDataSetChanged();
						Toast.makeText(all_tasks_page_activity.this, "Berhasil", Toast.LENGTH_SHORT).show();
					}
				})
				.addOnFailureListener(new OnFailureListener() {
					@Override
					public void onFailure(@NonNull Exception e) {
						// Handle any errors that occurred during data retrieval
					}
				});
	
		
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
	
	