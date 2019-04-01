package com.example.user.sharedpreference;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    EditText etNama, etPassword;
    Button btnKirim;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String user,pass;
    Boolean savelogin;
    Toolbar toolbar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.b);
        btnKirim = findViewById(R.id.btn);
        etPassword = findViewById(R.id.d);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        editor.putBoolean("savelogin",true);
        editor.apply();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etNama.getText().toString();
                String pass = etPassword.getText().toString();
                if(user.equals("123")&& pass.equals("123")){
                    Toast.makeText(MainActivity.this,"LOGIN BERHASIL",Toast.LENGTH_LONG).show();
                    editor = sharedPreferences.edit();
                    editor.putString("logged","logged");
                    editor.commit();
                    savelogin = sharedPreferences.getBoolean("savelogin",false);
                    if (savelogin==true) {
                        Intent a = new Intent(getApplicationContext(),SecondActivity.class);
                        a.putExtra("username", user);
                        a.putExtra("password", pass);
                        startActivity(a);
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "UserName dan Password disimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}