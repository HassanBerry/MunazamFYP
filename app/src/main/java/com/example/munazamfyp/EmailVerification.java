package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EmailVerification extends AppCompatActivity {
    EditText code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);
        code = findViewById(R.id.editText5);
    }
    static String verificatationcode;



    void getCode(String vc)
    {
        verificatationcode = vc;
    }

    public void compare(View view)
    {


        verificatationcode = Data.code;
        System.out.println(verificatationcode);
        if (verificatationcode.equals(code.getText().toString()))
        {
            Intent i = new Intent(this,Login.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Incorrect Code", Toast.LENGTH_SHORT).show();
        }
    }
}