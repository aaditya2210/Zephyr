package com.example.voltify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Feedback extends AppCompatActivity {

    Button feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        feedback =(Button) findViewById(R.id.Feedback);
        feedback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String UriText = "mailto:" + Uri.encode("aadityagandhi2210@gmail.com") +"?subject="+
                        Uri.encode("Feedback") +"$body="+ Uri.encode("");
                Uri uri = Uri.parse(UriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent,"send email"));
            }
        });

    }
}