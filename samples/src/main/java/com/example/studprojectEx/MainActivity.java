package com.example.studprojectEx;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();

        SharedPreferences settings = getSharedPreferences("Manager", Context.MODE_PRIVATE);

        ((TextView) findViewById(R.id.textView4)).setText("Баланс: " + settings.getInt("value", 1000) + " баллов");
    }

    private void initButtons()
    {
        ((Button) findViewById(R.id.check_in_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), DecoderActivity.class));
            }
        });

        ((Button) findViewById(R.id.matches_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), MatchesActivity.class));
            }
        });

        ((Button) findViewById(R.id.tickets_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), TicketsActivity.class));
            }
        });
    }


}