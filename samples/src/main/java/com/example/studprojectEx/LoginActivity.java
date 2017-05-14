package com.example.studprojectEx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Anton on 12.05.2017.
 */

public class LoginActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		initButtons();
	}

	private void initButtons()
	{
		((Button) findViewById(R.id.login)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(LoginActivity.this, MainActivity.class));
			}
		});

		((Button) findViewById(R.id.register)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				//TODO регистрация
			}
		});
	}
}
