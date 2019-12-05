package com.example.locationalarm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LocationAlarmInfoActivity extends MainActivity implements View.OnClickListener{
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE";

    Button btnClickMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_alarm_info);



        //Intialization Button
        btnClickMe = (Button) findViewById(R.id.SubmitButton);

        btnClickMe.setOnClickListener(LocationAlarmInfoActivity.this);
        //Here MainActivity.this is a Current Class Reference (context)

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String UT = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        EditText userTime = (EditText) findViewById(R.id.userTime);
        String UT = userTime.getText().toString();
        userInput = Integer.parseInt(UT);
        MyAlarm alarm = new MyAlarm(this, bundle, userInput);
    }


    /** Called when the user taps the Submit button */
    public void sendMessage(View view) {
        //undle bundle = new Bundle();
        Intent intent = new Intent(this, LocationAlarmInfoActivity.class);
        EditText userTime = (EditText) findViewById(R.id.userTime);
        String UT = userTime.getText().toString();
        userInput = Integer.parseInt(UT);
        //MyAlarm alarm = new MyAlarm(this, bundle, 10);
        intent.putExtra(EXTRA_MESSAGE2, UT);
        startActivity(intent);
    }
}
