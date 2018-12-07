package com.example.mohsen.form;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textCreate;
    EditText editFirstName;
    EditText editLostName;
    EditText editPhoneNumber;
    EditText editEmail;
    EditText editAge;


    String firstName;
    String lostName;
    String phoneNumber;
    String Email;
    String Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        textCreate = findViewById(R.id.txtCreate);
        editFirstName = findViewById(R.id.edtFirstName);
        editLostName = findViewById(R.id.edtLastName);
        editPhoneNumber = findViewById(R.id.edtPhoneNumber);
        editEmail=findViewById(R.id.edtEmail);
        editAge = findViewById(R.id.edtAge);

        //set button for Exit on DrawerLayout
        Button buttonExit=findViewById(R.id.btnExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitAlert();
            }
        });


        Button buttonNext = findViewById(R.id.btn);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = editFirstName.getText().toString();
                lostName = editLostName.getText().toString();
                phoneNumber = editPhoneNumber.getText().toString();
                Email = editEmail.getText().toString();
                Age = editAge.getText().toString();

                Intent intent=new Intent(MainActivity.this,Second.class);
                intent.putExtra("personalcontent0",firstName);
                intent.putExtra("personalcontent1",lostName);
                intent.putExtra("personalcontent2",phoneNumber);
                intent.putExtra("personalcontent3",Email);
                intent.putExtra("personalcontent4",Age);

                startActivityForResult(intent,100);


            }
        });


    }


 public void exitAlert(){
     AlertDialog alertExit=new AlertDialog.Builder(MainActivity.this).create();
     alertExit.setTitle("WARNING!");
     alertExit.setMessage("Do you want to exit?");
     alertExit.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
             finish();

         }
     });
     alertExit.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {


         }
     });
     alertExit.show();
 }

   //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String secondAnswer;
        if(requestCode==100){
            if(resultCode==RESULT_OK){
                secondAnswer=data.getStringExtra("result");

                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("firstName",firstName).apply();
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("lostName",lostName).apply();
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("phoneNumber",phoneNumber).apply();
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("Email",Email).apply();
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("Age",Age).apply();

                Toast.makeText(this,secondAnswer,Toast.LENGTH_LONG).show();
            }
        }
    }
}
