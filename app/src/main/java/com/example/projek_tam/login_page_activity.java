package com.example.projek_tam;

import android.app.Activity;
import android.os.Bundle;


import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class login_page_activity extends AppCompatActivity {

	
	private View _bg__login_page;
	private View rectangle_3;
	private EditText username_ek1;
	private View rectangle_5;
	private EditText katasandi;
	private TextView hi;
	private TextView welcome_again_;
	private TextView please_fill_in_your_correct_details_;
	private View rectangle_5_ek1;
	private TextView login;
	private View rectangle_5_ek2;
	private TextView continue_with_google;
	private TextView or;
	private View rectangle_5_ek3;
	private TextView _create_new_account;
	private FirebaseFirestore firestore;

	private RelativeLayout google;

	GoogleSignInOptions gso;
	GoogleSignInClient gsc;
	private ActivityResultLauncher<Intent> signInLauncher;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		firestore = FirebaseFirestore.getInstance();
		
		_bg__login_page = (View) findViewById(R.id._bg__login_page);
		rectangle_3 = (View) findViewById(R.id.rectangle_3);
		username_ek1 = (EditText) findViewById(R.id.username_ek1);
		rectangle_5 = (View) findViewById(R.id.rectangle_5);
		katasandi = (EditText) findViewById(R.id.katasandi);
		hi = (TextView) findViewById(R.id.hi);
		welcome_again_ = (TextView) findViewById(R.id.welcome_again_);
		please_fill_in_your_correct_details_ = (TextView) findViewById(R.id.please_fill_in_your_correct_details_);
		rectangle_5_ek1 = (View) findViewById(R.id.rectangle_5_ek1);
		login = (TextView) findViewById(R.id.login);
		rectangle_5_ek2 = (View) findViewById(R.id.rectangle_5_ek2);
		continue_with_google = (TextView) findViewById(R.id.continue_with_google);
		or = (TextView) findViewById(R.id.or);
		rectangle_5_ek3 = (View) findViewById(R.id.rectangle_5_ek3);
		_create_new_account = (TextView) findViewById(R.id._create_new_account);
		google = findViewById(R.id.google);


		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String username = username_ek1.getText().toString().trim();
				String password = katasandi.getText().toString().trim();

				if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
					Toast.makeText(getApplicationContext(), "Please fill in both username and password", Toast.LENGTH_SHORT).show();
				} else {

					login();
				}
			}
		});
		_create_new_account.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), create_account_screen_activity.class);
				startActivity(nextScreen);
			}
		});
		gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
		gsc = GoogleSignIn.getClient(this,gso);

		GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
		if(acct!=null){
			navigateToSecondActivity();
		}

		signInLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
			if (result.getResultCode() == RESULT_OK) {
				Intent data = result.getData();
				Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
				handleSignInResult(task);
			} else {
				Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
			}
		});

		google.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				signIn();
			}

		});

		//custom code goes here
	
	}
	private void signIn() {
		Intent signInIntent = gsc.getSignInIntent();
		signInLauncher.launch(signInIntent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 1000){
			Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

			try {
				task.getResult(ApiException.class);
				navigateToSecondActivity();
			} catch (ApiException e) {
				Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
			}
		}

	}

	private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
		try {
			GoogleSignInAccount account = completedTask.getResult(ApiException.class);
			navigateToSecondActivity();
		} catch (ApiException e) {
			Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
		}
	}
	private void navigateToSecondActivity() {
		Intent intent = new Intent(login_page_activity.this, all_tasks_page_activity.class);
		startActivity(intent);
		finish();
	}
	private void login() {
		String username = username_ek1.getText().toString().trim();
		String password = katasandi.getText().toString().trim();

		firestore.collection("users")
				.whereEqualTo("Username", username)
				.whereEqualTo("Password", password)
				.get()
				.addOnCompleteListener(task -> {
					if (task.isSuccessful()) {
						QuerySnapshot querySnapshot = task.getResult();
						if (querySnapshot != null && !querySnapshot.isEmpty()) {
							navigateToSecondActivity();
						} else {
							Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
						}
					} else {
						Toast.makeText(getApplicationContext(), "Failed to retrieve user data", Toast.LENGTH_SHORT).show();
					}
				});
	}
}


	
	