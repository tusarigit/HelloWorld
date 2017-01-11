package com.example.tusar.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {
    protected TextView speed, latitude, longitude;
    protected BroadcastReceiver message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Toast.makeText(ActivityOne.this,"onCreate();",Toast.LENGTH_LONG).show();
        speed = (TextView) findViewById(R.id.textView1);
        latitude = (TextView) findViewById(R.id.textView2);
        longitude = (TextView) findViewById(R.id.textView3);
          message = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Double speed_received = intent.getDoubleExtra("Currnet speed", 10);
                Double latittude_received = intent.getDoubleExtra("latitude", 0);
                Double longitude_received = intent.getDoubleExtra("longitude", 0);
                Toast.makeText(ActivityOne.this,"abc"+speed_received+" "+latittude_received+" "+longitude_received,Toast.LENGTH_LONG).show();

                speed.setText("speed :    " + speed_received);


                latitude.setText("latitude :   " + latittude_received);


                longitude.setText("longitude :    " + longitude_received);
            }
        };

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(ActivityOne.this,"onResume();",Toast.LENGTH_LONG).show();
        LocalBroadcastManager.getInstance(this).registerReceiver(message, new IntentFilter("send"));

    }


    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(message);
        Toast.makeText(ActivityOne.this,"onPause();",Toast.LENGTH_LONG).show();
    }





}
