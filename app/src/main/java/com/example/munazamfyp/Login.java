package com.example.munazamfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.munazamfyp.Connections.SIgninConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.UserData;

public class Login extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginAction(View view)
    {
        final EditText name = findViewById(R.id.editText6);
        final EditText pass = findViewById(R.id.editText7);

        if(name.getText().toString() != null && pass.getText().toString() != null)
        {
            new SIgninConnection(name.getText().toString(),pass.getText().toString()).execute();

            handler =new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(!Data.status.equals("notok"))
                    {
                        Toast.makeText(Login.this, "Welcome", Toast.LENGTH_SHORT).show();
                        UserData.name = name.getText().toString();
                        UserData.password = pass.getText().toString();

                        System.out.println("id == "+Data.status);

                        SharedPreferences sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("id",Data.status);
                        editor.putString("name", name.getText().toString());
                        editor.apply();

                        Intent i = new Intent(Login.this,mainmenu.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Login.this,"Incorrecnt Password",Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }
            },2000);

        }

    }
    public void opencreateaccount(View view)
    {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
    }
}
