package com.b1company.datetimeformat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView tvDTFormat;

    Date date;
    SimpleDateFormat formater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDTFormat = findViewById(R.id.tvDTFormat);

        //tvDTFormat.setText(System.currentTimeMillis() + "");

        date = new Date( System.currentTimeMillis() );

        formater = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aaa");
        String formattedDT = formater.format(date);

        tvDTFormat.setText(formattedDT);

        method1();
    }

    public void method1() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                date = new Date( System.currentTimeMillis() );
                tvDTFormat.setText(formater.format(date));
                method1();
            }
        }, 1000);
    }
}
