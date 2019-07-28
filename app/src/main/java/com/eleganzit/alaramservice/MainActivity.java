package com.eleganzit.alaramservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int hour[]={8,9,10,11,12,13,14,15,16,17,18,19,20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      Intent  intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.setAction(Intent.ACTION_MAIN);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0,
                intent, 0);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        int alarmType = AlarmManager.ELAPSED_REALTIME;
        final int FIFTEEN_SEC_MILLIS = 15000;

        // The AlarmManager, like most system services, isn't created by application code, but
        // requested from the system.
        AlarmManager alarmManager = (AlarmManager)
                getSystemService(ALARM_SERVICE);

        // setRepeating takes a start delay and period between alarms as arguments.
        // The below code fires after 15 seconds, and repeats every 15 seconds.  This is very
        // useful for demonstration purposes, but horrendous for production.  Don't be that dev.
        alarmManager.setRepeating(alarmType, SystemClock.elapsedRealtime() + FIFTEEN_SEC_MILLIS,
                FIFTEEN_SEC_MILLIS, pendingIntent);


    }

}
