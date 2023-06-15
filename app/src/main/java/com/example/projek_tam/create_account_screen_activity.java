package com.example.projek_tam;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class create_account_screen_activity extends Activity {

	
	private View _bg__create_account_screen;
	private View rectangle_3;
	private EditText username_ek1;
	private View rectangle_4;
	private EditText phone_number;
	private View rectangle_5;
	private EditText password;
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
	private DocumentReference sendRef;


	private  FirebaseAuth mAuth;
	private FirebaseFirestore db;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_account_screen);


		
		_bg__create_account_screen = (View) findViewById(R.id._bg__create_account_screen);
		rectangle_3 = (View) findViewById(R.id.rectangle_3);
		username_ek1 = (EditText) findViewById(R.id.username_ek1);
		rectangle_4 = (View) findViewById(R.id.rectangle_4);
		phone_number = (EditText) findViewById(R.id.phone_number);
		rectangle_5 = (View) findViewById(R.id.rectangle_5);
		password = (EditText) findViewById(R.id.password);
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

		mAuth = FirebaseAuth.getInstance();


		create_account.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				String username = username_ek1.getText().toString().trim();
				String phoneNumber = phone_number.getText().toString().trim();
				String katasandi = password.getText().toString().trim();

				db = FirebaseFirestore.getInstance();
				Map<String, Object> login = new HashMap<>();
				login.put("Username", username);
				login.put("Phone Number", phoneNumber);
				login.put("Password", katasandi);
				sendRef = db.collection("users").document();

				sendRef.set(login).addOnSuccessListener(new OnSuccessListener<Void>() {
							@Override
							public void onSuccess(Void aVoid) {
								Toast.makeText(create_account_screen_activity.this, "Product saved to Firestore", Toast.LENGTH_SHORT).show();
							}
						})
						.addOnFailureListener(new OnFailureListener() {
							@Override
							public void onFailure(@NonNull Exception e) {

								Toast.makeText(create_account_screen_activity.this, "Failed to save product", Toast.LENGTH_SHORT).show();
							}
						});
				Intent nextScreen = new Intent(getApplicationContext(), verified_activity.class);
				startActivity(nextScreen);
				finish();
			}
		});
	}
}
	
	