package com.example.android_proektna;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUserEmail;
    private EditText etPassword;
    public String username;
    private String password;
    String storedPassword;
    Context context=this;


    LoginDatabaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create the instance of Databse
        loginDataBaseAdapter=new LoginDatabaseAdapter(getApplicationContext());

        etUserEmail = (EditText) findViewById(R.id.Email);
        etPassword = (EditText) findViewById(R.id.Password);

    }

    public void SignIN(View view) {

        try {

            loginDataBaseAdapter = loginDataBaseAdapter.open();
            username = etUserEmail.getText().toString();
            password = etPassword.getText().toString();

            if (username.equals("") || password.equals("")) {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("ALERT!");
                alertDialog.setMessage("Fill All Fields");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialog.show();
            }

            // fetch the Password form database for respective user name
            if (!username.equals("")) {
                storedPassword = loginDataBaseAdapter.getSinlgeEntry(username);

                // check if the Stored password matches with Password entered by user
                if (password.equals(storedPassword)) {
                    Intent intent1 = new Intent(MainActivity.this, DisplayInfoActivity.class);
                    startActivity(intent1);
                    // finish();
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("ALERT!");
                    alertDialog.setMessage("Incorrect Username OR Password");
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alertDialog.show();
                }
            }
        }
        catch (Exception ex)
        {
            Log.e("Error", "error login");
        }

    }




    public void SignUP(View view)
    {
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();

        // Close The Database
        loginDataBaseAdapter.close();
    }
}