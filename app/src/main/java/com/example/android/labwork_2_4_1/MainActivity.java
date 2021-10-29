package com.example.android.labwork_2_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button secondAct, byUrl, pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondAct = findViewById(R.id.btnSecond);
        byUrl = findViewById(R.id.btnByUrl);
        pendingIntent = findViewById(R.id.btnPending);

        // Second Activity
        secondAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // URL
        byUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://ru.wikipedia.org/wiki/Android"));
                startActivity(intent);
            }
        });

        // PendingIntent
        pendingIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int seconds = 3;
                Intent intent = new Intent(MainActivity.this, MyReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        MainActivity.this, 1, intent, 0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                        + (seconds * 1000), pendingIntent);

                Toast.makeText(MainActivity.this, "Старт Second Activity через " + seconds +
                        " секунд", Toast.LENGTH_LONG).show();


            }
        });

    }
}