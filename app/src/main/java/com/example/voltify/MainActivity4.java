package com.example.voltify;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity4 extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    TextView textView3,textView8;
    FirebaseUser currentUser;//used to store current user of account
    FirebaseAuth mAuth;//Used for firebase authentication
    ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        textView8 = (TextView) findViewById(R.id.textView8);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(getString(R.string.welcome));

        TextPaint paint = textView3.getPaint();
        float width = paint.measureText("Zephyr");

        Shader textShader = new LinearGradient(0, 0, width, textView3.getTextSize(),
                new int[]{
                        Color.parseColor("#553bdd"),
                        Color.parseColor("#fe2485"),
                        Color.parseColor("#fdd55b"),
                }, null, Shader.TileMode.CLAMP);
        textView3.getPaint().setShader(textShader);

        textView8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);
            }
        });


        loginButton.setOnClickListener(view -> {
            if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                Toast.makeText(MainActivity4.this, "Login Successful!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(MainActivity4.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
            // invoke the SecondActivity.

            Intent i = new Intent(MainActivity4.this, Dashboard.class);
            startActivity(i);
            finish();
        });


        mAuth = FirebaseAuth.getInstance();
        loadingBar = new ProgressDialog(this);
        currentUser = mAuth.getCurrentUser();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllowUserToLogin();
            }
        });
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendUserToRegister();
//            }
//        });
        //if user forgets the password then to reset it
//        forgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resetPasswordUser();
//            }
//        });
    }

    private void resetPasswordUser() {
        String email = username.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(MainActivity4.this,"Please enter your email id",Toast.LENGTH_SHORT).show();
        }
        else
        {
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity4.this, "Reset Email sent", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void sendUserToRegister() {
        //When user wants to create a new account send user to Register Activity
        Intent registerIntent = new Intent(MainActivity4.this, MainActivity5.class);
        startActivity(registerIntent);
    }

    private void AllowUserToLogin() {
        String email = username.getText().toString().trim();
        String pwd = password.getText().toString();
//        sendToMainActivity();
//        sendToMainActivity();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(MainActivity4.this,"Please enter email id",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pwd))
        {
            Toast.makeText(MainActivity4.this,"Please enter password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            //When both email and password are available log in to the account
            //Show the progress on Progress Dialog
            loadingBar.setTitle("Sign In");
            loadingBar.setMessage("Please wait ,Because Good things always take time");
            mAuth.signInWithEmailAndPassword(email,pwd)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())//If account login successful print message and send user to main Activity
                            {
                                sendToMainActivity();
                                Toast.makeText(MainActivity4.this,"Welcome to Zephyr",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                            else//Print the error message incase of failure
                            {
                                String msg = task.getException().toString();
                                Toast.makeText(MainActivity4.this,"Error: "+msg,Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });
        }
    }


    private void sendToMainActivity() {
        //This is to send user to MainActivity
        Intent  MainIntent = new Intent(MainActivity4.this, Dashboard.class);
        startActivity(MainIntent);
        finish();

    }
}
