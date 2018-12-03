package com.example.mohsen.form;

import android.content.Intent;
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

        Button button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
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

                startActivity(intent);
               // textCreate.setText(name);
               // Toast.makeText(getBaseContext(),"hello", Toast.LENGTH_LONG).show();

            }
        });
    }
}
