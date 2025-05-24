package com.example.voltify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Range_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_calc);

        Spinner spinner = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.loginButton);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               int value = Integer.parseInt(password.getText().toString());
//
//               if(item=="Cybertruck")
//               {
//
//               }
//
//            }
//        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(Range_Calc.this, "Selected Car: "+item, Toast.LENGTH_SHORT).show();
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        int value = Integer.parseInt(password.getText().toString());

                        if(item.equals("Cybertruck"))
                        {
                            String s = password.getText().toString();
                            Double f = Double.parseDouble(s);

                            Double f1=123.0;

                            Double result = (((f*f1)/100)*450)/123; //kwh ma male
                            String r = result.toString();
                            Intent in = new Intent(getApplicationContext(), evcar_card1.class);
                            in.putExtra("message_key",r);
                            startActivity(in);



                        }

                        if(item.equals("Model Y"))
                        {
                            String s = password.getText().toString();
                            Double f = Double.parseDouble(s);

                            Double f1=57.5;

                            Double result = (((f*f1)/100)*455)/57.5; //kwh ma male
                            String r = result.toString();
                            Intent in = new Intent(getApplicationContext(), evcar_card2.class);
                            in.putExtra("message_key",r);
                            startActivity(in);



                        }


                        if(item.equals("Model X"))
                        {
                            String s = password.getText().toString();
                            Double f = Double.parseDouble(s);

                            Double f1=100.0;

                            Double result = (((f*f1)/100)*536)/100; //kwh ma male
                            String r = result.toString();
                            Intent in = new Intent(getApplicationContext(), evcar_card3.class);
                            in.putExtra("message_key",r);
                            startActivity(in);



                        }

                        if(item.equals("E-tron"))
                        {
                            String s = password.getText().toString();
                            Double f = Double.parseDouble(s);

                            Double f1=95.0;

                            Double result = (((f*f1)/100)*364)/95; //kwh ma male
                            String r = result.toString();
                            Intent in = new Intent(getApplicationContext(), evcar_card4.class);
                            in.putExtra("message_key",r);
                            startActivity(in);



                        }


                        if(item.equals("EV-6"))
                        {
                            String s = password.getText().toString();
                            Double f = Double.parseDouble(s);

                            Double f1=77.4;

                            Double result = (((f*f1)/100)*708)/77.4; //kwh ma male
                            String r = result.toString();
                            Intent in = new Intent(getApplicationContext(), evcar_card5.class);
                            in.putExtra("message_key",r);
                            startActivity(in);



                        }

                    }
                });
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });






        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Cybertruck");
        arrayList.add("Model Y");
        arrayList.add("Model X");
        arrayList.add("E-tron");
        arrayList.add("EV-6");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,arrayList);

        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

    }
}