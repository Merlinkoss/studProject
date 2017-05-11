package com.example.qr_readerexample;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Anton on 11.05.2017.
 */

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		TextView count = ((TextView)findViewById(R.id.count));
		String balls = String.valueOf(getSharedPreferences("Manager", Context.MODE_PRIVATE).getInt("value", 1000));
		count.setText(balls);

		initButtons();
	}

	private void initButtons()
	{
		Button readQr = (Button) findViewById(R.id.checkCodes);
		readQr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(MainActivity.this, DecoderActivity.class));
			}
		});
	}

}
