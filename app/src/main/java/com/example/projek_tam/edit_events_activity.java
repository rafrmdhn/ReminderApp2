package com.example.projek_tam;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class edit_events_activity extends Activity {

	private View rectangle_11;
	private View rectangle_3;
	private TextView selanjutnya;
	private View rectangle_12;
	private View line_5;
	private EditText nama_acara;
	private TextView edit_acara;
	private TextView selesai;
	private TextView _batalkan;
	private EditText lokasi;
	private View rectangle_13;
	private View rectangle_14;
	private ImageView line_7;
	private TextView jumat_agung_ek1;
	private EditText mulai;
	private TextView url;
	private EditText _catetan;
	private EditText berakhir;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_events);

		rectangle_11 = (View) findViewById(R.id.rectangle_11);
		selanjutnya = (TextView) findViewById(R.id.selanjutnya);
		rectangle_12 = (View) findViewById(R.id.rectangle_12);
		nama_acara = (EditText) findViewById(R.id.nama_acara);
		edit_acara = (TextView) findViewById(R.id.edit_acara);
		selesai = (TextView) findViewById(R.id.selesai);
		_batalkan = (TextView) findViewById(R.id._batalkan);
		lokasi = (EditText) findViewById(R.id.lokasi);
		rectangle_13 = (View) findViewById(R.id.rectangle_13);
		rectangle_14 = (View) findViewById(R.id.rectangle_14);
		jumat_agung_ek1 = (TextView) findViewById(R.id.jumat_agung_ek1);
		mulai = (EditText) findViewById(R.id.mulai);
		url = (TextView) findViewById(R.id.url);
		_catetan = (EditText) findViewById(R.id._catetan);
		berakhir = (EditText) findViewById(R.id.berakhir);


		Intent intent = getIntent();
		String selectedDay = intent.getStringExtra("selectedDay");
		String selectedMonthYear = intent.getStringExtra("selectedMonthYear");


		_batalkan.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), calendar.class);
				startActivity(nextScreen);
				finish();
			}
		});

		selesai.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				String acara = nama_acara.getText().toString();
				String lok = lokasi.getText().toString();
				String start = mulai.getText().toString();
				String end = berakhir.getText().toString();
				String note = _catetan.getText().toString();
				Date today = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
				String tanggal = dateFormat.format(today);
				String idDoc = selectedDay + " " + selectedMonthYear;

				FirebaseFirestore db = FirebaseFirestore.getInstance();
				Map<String, Object> date = new HashMap<>();
				date.put("Acara", acara);
				date.put("Lokasi", lok);
				date.put("Mulai", start);
				date.put("Berakhir", end);
				date.put("Catatan", note);
				date.put("Tanggal", idDoc);



				db.collection("Calendar")
						.add(date)
						.addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
							@Override
							public void onSuccess(DocumentReference documentReference) {
								Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
							}
						})
						.addOnFailureListener(new OnFailureListener() {
							@Override
							public void onFailure(@NonNull Exception e) {
								Log.w(TAG, "Error adding document", e);
							}
						});
				Intent nextScreen = new Intent(getApplicationContext(), calendar.class);
				startActivity(nextScreen);
				finish();
			}


		});

		selanjutnya.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), calendar.class);
				startActivity(nextScreen);
				finish();
			}
		});

//		_catetan.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), edit_events_2_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});

	
	}

}
	
	