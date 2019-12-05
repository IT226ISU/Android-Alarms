package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class CreateAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.alarm_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void create(View v) {
        EditText setTime = findViewById(R.id.editText6);
        EditText date = findViewById(R.id.editText5);
        EditText message = findViewById(R.id.editText7);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String choice = spinner.getSelectedItem().toString();
        String newDate = date.getText().toString();
        String newTime = setTime.getText().toString();
        int hour = Integer.parseInt(newTime.split("\\:")[0]);
        int minute = Integer.parseInt(newTime.split("\\:")[1]);
        int month = Integer.parseInt(newDate.split("\\/")[0]);
        int day = Integer.parseInt(newDate.split("\\/")[1]);
        int year = Integer.parseInt(newDate.split("\\/")[2]);
        Calendar time = Calendar.getInstance();
        time.set(0,0,0,0,0);
        time.add(Calendar.DAY_OF_MONTH, day);
        time.add(Calendar.MONTH, month - 1);
        time.add(Calendar.YEAR, year);
        long total = TimeUnit.HOURS.toMillis(hour) + TimeUnit.MINUTES.toMillis(minute);
        total = total + time.getTimeInMillis();
        total = total - System.currentTimeMillis();
        time.setTimeInMillis(System.currentTimeMillis());
        if(choice.equals("One-Time")){
//            AlarmManager alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
//            Intent intent = new Intent(this, MyAlarmReceiver.class);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
//            alarmMgr.set(AlarmManager.RTC_WAKEUP,time.getTimeInMillis() + total, pendingIntent);
            Bundle bundle = new Bundle();
            int num = (int)total;
            MyAlarmReceiver alarm1 = new MyAlarmReceiver(this,bundle, num);

        }
        else if (choice.equals("Location")){

        }
        else{
            AlarmManager alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, MyAlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, time.getTimeInMillis() + total, TimeUnit.DAYS.toMillis(7), pendingIntent);
        }
    }
}
