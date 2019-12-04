package com.example.locationalarm2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LocationAlarmInfoActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_alarm_info);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }
    /** Called when the user taps the Submit button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, LocationAlarmInfoActivity.class);
        EditText userTime = (EditText) findViewById(R.id.userTime);
        String UT = userTime.getText().toString();
        intent.putExtra(EXTRA_MESSAGE2, UT);
        startActivity(intent);
    }
}
