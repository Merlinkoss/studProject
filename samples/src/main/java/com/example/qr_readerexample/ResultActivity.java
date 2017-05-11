package com.example.qr_readerexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Anton on 11.05.2017.
 */

public class ResultActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_result);

		initButton(getIntent().getExtras().getString("code"));
	}

	public void initButton(final String text)
	{
		Button accept = (Button) findViewById(R.id.accept);
		Button cancel = (Button) findViewById(R.id.cancel);

		accept.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				SharedPreferences settings = getSharedPreferences("Manager", Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = settings.edit();
				editor.putInt("value", settings.getInt("value", 1000) + calculateHim(text) );
				editor.commit();

				cancelAction();
			}
		});

		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				cancelAction();
			}
		});
	}

	private int calculateHim(String text)
	{
		if(text.equals("Bulochka125")) return -125;
		else if(text.equals("Voda50")) return -50;

		return 0;
	}

	public void cancelAction()
	{
		startActivity(new Intent(this, MainActivity.class));
	}

	@Override
	public void onBackPressed()
	{
		cancelAction();
	}

}
