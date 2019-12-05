package com.example.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;

public class MyAlarmReceiver extends BroadcastReceiver {
    private static final String REMINDER_BUNDLE = "MyReminderBundle";

    public MyAlarmReceiver(){}

    public MyAlarmReceiver(Context context, Bundle extras, int timeoutInSeconds){
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MyAlarmReceiver.class);
        intent.putExtra(REMINDER_BUNDLE, extras);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent,  PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(System.currentTimeMillis());
        time.add(Calendar.MILLISECOND, timeoutInSeconds);
        alarmMgr.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingIntent);
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm went off", Toast.LENGTH_SHORT).show();
    }
}