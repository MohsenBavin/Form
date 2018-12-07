package com.example.mohsen.form;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    TextView txtHi;
    TextView txtShowName;
    TextView txtShowPhone;
    TextView txtEmail;
    TextView txtAge;
    Button buttonSave;

    String firstNameGet;
    String lastNameGet;
    String phoneNumberGet;
    String EmailAdressGet;
    String AgeGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        txtHi=findViewById(R.id.txtHi);
        txtShowName=findViewById(R.id.txtShowName);
        txtShowPhone = findViewById(R.id.txtShowNumber);
        txtEmail = findViewById(R.id.txtShowEmail);
        txtAge = findViewById(R.id.txtShowAge);
        buttonSave=findViewById(R.id.btnsav);

        Intent intent=getIntent();

        firstNameGet = intent.getStringExtra("personalcontent0");
        lastNameGet = intent.getStringExtra("personalcontent1");
        phoneNumberGet = intent.getStringExtra("personalcontent2");
        EmailAdressGet = intent.getStringExtra("personalcontent3");
        AgeGet = intent.getStringExtra("personalcontent4");

        txtHi.setText("Hi  "+ firstNameGet);
        txtShowName.setText(firstNameGet+" "+lastNameGet);
        txtShowPhone.setText(phoneNumberGet);
        txtEmail.setText(EmailAdressGet);
        txtAge.setText(AgeGet);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnintent= new Intent();
                returnintent.putExtra("result","Your information has been saved successfully");
                setResult(MainActivity.RESULT_OK,returnintent);
                finish();

            }
        });

    }


}
