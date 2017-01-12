package com.example.tusar.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        sendBroadcast();
        startActivity(new Intent(MainActivity.this, ActivityOne.class));
    }

    private void sendBroadcast() {

        Intent i = new Intent("send");
        i.putExtra("Currnet speed", "102.4");
        i.putExtra("latitude", "12.2342342");
        i.putExtra("longitude", "12.21124");
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);
    }
}


