package com.example.android_proektna;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFormActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_form_activity);
    }

    public void onClick(View view) {

        Toast.makeText(context,"Successfully registered!", Toast.LENGTH_SHORT).show();

        }
}
