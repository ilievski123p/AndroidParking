package com.example.android_proektna;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class SignUp extends AppCompatActivity {

    Context context=this;
    private EditText et_first_name;
    private EditText et_last_name;
    private EditText et_ID;
    private EditText et_password;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    String receieveOk;
    LoginDatabaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // get Instance of Database Adapter
        loginDataBaseAdapter=new LoginDatabaseAdapter(getApplicationContext());
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        et_first_name = (EditText) findViewById(R.id.tFirstName);
        et_last_name = (EditText) findViewById(R.id.tLastName);
        et_ID = (EditText) findViewById(R.id.tEmail);
        et_password = (EditText) findViewById(R.id.tPassword);


    }

    public void OK(View view)
    {

        firstName = et_first_name.getText().toString();
        lastName = et_last_name.getText().toString();
        userName = et_ID.getText().toString();
        password = et_ID.getText().toString();
        if((firstName.equals(""))||(lastName.equals(""))||(userName.equals(""))||(password.equals("")))
        {
            //Display Message
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ALERT!");
            alertDialog.setMessage("All fields must be filled");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.show();
        }
        else
        {

            // Save the Data in Database
            receieveOk=loginDataBaseAdapter.insertEntry(firstName,lastName,userName, password);

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("SUCCESSFUL!");
            alertDialog.setMessage("SIGN IN NOW " + receieveOk);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            alertDialog.show();
            finish();
        }

    }

    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}