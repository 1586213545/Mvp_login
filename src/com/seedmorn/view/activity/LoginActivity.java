package com.seedmorn.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.seedmorn.model.entity.User;
import com.seedmorn.presenter.UserLoginPresenter;
import com.seedmorn.view.in.IUserLoginView;
import com.seedmorn.w33.R;

public class LoginActivity extends Activity implements IUserLoginView {

	private EditText id_et_username;
	private EditText id_et_password;
	private Button id_btn_clear;
	private Button id_btn_login;
	private ProgressBar id_pb_loading;

	private UserLoginPresenter userLoginPresenter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		userLoginPresenter = new UserLoginPresenter(this);
		initView();
	}

	private void initView() {
		id_et_username = (EditText) findViewById(R.id.et_username);
		id_et_password = (EditText) findViewById(R.id.et_password);
		id_btn_clear = (Button) findViewById(R.id.btn_clear);
		id_btn_login = (Button) findViewById(R.id.btn_login);
		id_pb_loading = (ProgressBar) findViewById(R.id.pb_loading);
		
		
		id_btn_clear.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				userLoginPresenter.clear();
			}
		});
		
		
		id_btn_login.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				userLoginPresenter.preLogin();
			}
		});

	}

	public void showDialog() {
		id_pb_loading.setVisibility(View.VISIBLE);
	}

	public void hideDialog() {
		id_pb_loading.setVisibility(View.GONE);
	}

	public void showToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	public User getUser() {
		User user = new User();
		user.setUsername(id_et_username.getText().toString());
		user.setPassword(id_et_password.getText().toString());
		return user;
	}

	public void clearUser() {
		id_et_username.setText("");
		id_et_password.setText("");
	}

	public void toMainActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
