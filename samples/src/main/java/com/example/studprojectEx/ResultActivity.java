package com.example.studprojectEx;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
		final int calc = calculateHim(text);
		Button accept = (Button) findViewById(R.id.accept);
		Button cancel = (Button) findViewById(R.id.cancel);

		accept.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				SharedPreferences settings = getSharedPreferences("Manager", Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = settings.edit();
				editor.putInt("value", settings.getInt("value", 1000) + calc);
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
		TextView textView = (TextView) findViewById(R.id.textView5);

		if(text.equals("Bulochka125"))
		{
			textView.setText("Вы точно хотите приобрести булочку за 125 баллов?");
			return -125;
		}
		else if(text.equals("Voda50"))
		{
			textView.setText("Вы точно хотите приобрести воду за 50 баллов?");
			return -50;
		}
		else if(text.equals("bonus100"))
		{
			textView.setText("Вы получили 100 бонус баллов на счет!");
			return 100;
		}

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
