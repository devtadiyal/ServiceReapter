package com.example.devendratadiyal.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TimePicker tp = (TimePicker) findViewById(R.id.timePicker);
        final Button btnSet = (Button) findViewById(R.id.button);


        btnSet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                scheduleNextUpdate();
               /* String strDateTime = tp.getCurrentHour() + ":" + tp.getCurrentMinute();

           //     Toast.makeText(MainActivity.this, "User selected Time" + strDateTime, Toast.LENGTH_LONG).show(); //Generate a toast only

                Date d=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
                String currentDateTimeString = sdf.format(d);
             //   Toast.makeText(MainActivity.this, "Current Time " + currentDateTimeString, Toast.LENGTH_LONG).show(); //Generate a

                Intent myIntent = new Intent(MainActivity.this,MyService.class);
                PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this, 0, myIntent, 0);

                Calendar wakeUpTime = Calendar.getInstance();
                wakeUpTime.add(Calendar.SECOND,2000);
                AlarmManager aMgr = (AlarmManager) getSystemService(ALARM_SERVICE);
                aMgr.set(AlarmManager.RTC_WAKEUP, 2000, pendingIntent);*/
               /* AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + (100 * 60 * 2), pendingIntent);*/
            }});
    }

    private void scheduleNextUpdate()
    {
        Intent intent = new Intent(this, MyService.class);
        PendingIntent pendingIntent =
                PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);



        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC, 2500,1000 * 60 * 1, pendingIntent);
    }
}
