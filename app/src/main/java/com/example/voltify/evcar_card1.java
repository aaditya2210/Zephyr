package com.example.voltify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class evcar_card1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evcar_card1);
        TextView textView15 = findViewById(R.id.textView15);

        Intent in = getIntent();
        String str = in.getStringExtra("message_key");
        textView15.setText("Remaining Range->"+str+" Km");
    }
}