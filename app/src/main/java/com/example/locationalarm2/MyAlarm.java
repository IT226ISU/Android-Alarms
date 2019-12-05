package com.example.locationalarm2;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.Calendar;


public class MyAlarm extends BroadcastReceiver {

    private final String REMINDER_BUNDLE = "MyReminderBundle";

    // this constructor is called by the alarm manager.
    public MyAlarm(){ }

    public MyAlarm(Context context, Bundle extras, int timeoutInMinutes){
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MyAlarm.class);
        intent.putExtra(REMINDER_BUNDLE, extras);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(System.currentTimeMillis());
        time.add(Calendar.MINUTE, timeoutInMinutes);
        alarmMgr.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingIntent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // here you can get the extras you passed in when creating the alarm
        //intent.getBundleExtra(REMINDER_BUNDLE));
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
//        builder1.setMessage("Get up and move!");
//        builder1.setCancelable(true);
//
//        builder1.setPositiveButton(
//                "Continue",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        builder1.setNegativeButton(
//                "Close",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        AlertDialog alert11 = builder1.create();
//        alert11.show();
        Toast.makeText(context, "Get up and move!", Toast.LENGTH_LONG).show();
    }
}