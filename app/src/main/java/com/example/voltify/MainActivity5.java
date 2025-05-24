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

public class MainActivity5 extends AppCompatActivity {
    TextView textView,textView9;
    EditText username;
    EditText password;
    EditText nickname;
    Button loginButton;
//    TextView AccountExists;
    private FirebaseAuth mAuth;//Used for firebase authentication

    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        mAuth = FirebaseAuth.getInstance();
//        AccountExists = (TextView) findViewById(R.id.Already_link);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        nickname = findViewById(R.id.email);
        loginButton = findViewById(R.id.loginButton);

        textView9 = findViewById(R.id.textView9);
        textView = findViewById(R.id.textViewv);
        textView.setText(getString(R.string.welcome_to));

        TextPaint paint = textView.getPaint();
        float width = paint.measureText("Zephyr");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#553bdd"),
                        Color.parseColor("#fe2485"),
                        Color.parseColor("#fdd55b"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);








        textView9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                startActivity(intent);
            }
        });



        loadingBar = new ProgressDialog(this);
        //When user has  an account already he should be sent to login activity.
//        AccountExists.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendUserToLoginActivity();
//            }
//        });
        //When user clicks on register create a new account for user
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAccount();
//                String a = nickname.getText().toString();
//                Intent in = new Intent(getApplicationContext(), Dashboard.class);
//                in.putExtra("message_key",a);
//                startActivity(in);
            }
        });
    }

    private void createNewAccount() {
        String email = username.getText().toString().trim();
        String pwd = password.getText().toString();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(MainActivity5.this,"Please enter email id",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pwd))
        {
            Toast.makeText(MainActivity5.this,"Please enter password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            //When both email and password are available create a new account
            //Show the progress on Progress Dialog
            loadingBar.setTitle("Creating New Account");
            loadingBar.setMessage("Please wait, we are creating new Account");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();
            mAuth.createUserWithEmailAndPassword(email,pwd)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())//If account creation successful print message and send user to Login Activity
                            {
                                sendUserToLoginActivity();
                                Toast.makeText(MainActivity5.this,"Account created successfully",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                            else//Print the error message incase of failure
                            {
                                String msg = task.getException().toString();
                                Toast.makeText(MainActivity5.this,"Error: "+msg,Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });
        }
    }

    private void sendUserToLoginActivity() {
        //This is to send user to Login Activity.
        Intent loginIntent = new Intent(MainActivity5.this,MainActivity4.class);
        startActivity(loginIntent);
        finish();
        String a = nickname.getText().toString();
        Intent in = new Intent(getApplicationContext(), MainActivity4.class);
        in.putExtra("message_key",a);
        startActivity(in);
    }
}