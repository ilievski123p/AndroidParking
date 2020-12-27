package com.example.android_proektna;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android_proektna.models.City;

public class RegisterFormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatePicker datePicker;
    Spinner spinner;
    Button proceed;
    int mDay, mMonth, mYear;
    String mHours;
    City city;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.register_form_activity);

        } else {
            setContentView(R.layout.register_form_activity);

        }

        datePicker = (DatePicker) findViewById(R.id.date_widget_fragment_1);
        spinner = (Spinner) findViewById(R.id.spinner_fragment_1);
        proceed = (Button) findViewById(R.id.button_proceed);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hours, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Intent intent = getIntent();
         city  = intent.getParcelableExtra("city");

        int image_resource = city.getImage();
        String name_resource = city.getName();

        ImageView imageView = findViewById(R.id.image_fragment_2);
        imageView.setImageResource(image_resource);

        TextView textView = findViewById(R.id.city_text_fragment_2);
        textView.setText(name_resource);

        spinner.setOnItemSelectedListener(this);


        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mDay = dayOfMonth;
                mMonth = monthOfYear + 1;
                mYear = year;
            }
        });


        proceed.setOnClickListener(v -> {
            Intent intent1 = new Intent(v.getContext(), ParkingPlacesActivity.class);
            intent1.putExtra("day", mDay);
            intent1.putExtra("month", mMonth);
            intent1.putExtra("year", mYear);
            intent1.putExtra("hours", mHours);
            intent1.putExtra("city", city);
            startActivity(intent1);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mHours = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent = new Intent(this, MyReservations.class);
        startActivity(intent);
        return true;
    }
}