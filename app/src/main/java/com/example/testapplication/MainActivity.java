package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 private EditText id;
private EditText pas;
private Button bt ;
private TextView tx;
private Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id =findViewById(R.id.student_id);
        pas = findViewById(R.id.password);
        bt= findViewById(R.id.button1);
        sw=findViewById(R.id.switch1);
        tx=findViewById(R.id.note);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Toggle the password visibility based on the Switch state
                if (isChecked) {
                    // Show password
                    pas.setTransformationMethod(null); // Set to null to display plain text
                } else {
                    // Hide password
                    pas.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().equals("12345")&&pas.getText().toString().equals("admin")){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }else{
                    tx.setText("the pass or id num is not correct");
                }
        }});



    }
}