package com.example.android_proektna;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android_proektna.models.City;
import com.example.android_proektna.models.Reservation;

import java.util.ArrayList;

public class MyReservations extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyReservationAdapter mAdapter;
    TextView dateText;
    TextView numberHours;
    TextView cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_reservation);
        ArrayList<Reservation> myReservations = new ArrayList<Reservation>();
        DataBaseHelper handler = new DataBaseHelper(MyReservations.this);
        myReservations = handler.getReservations();
        //сетирање на RecyclerView контејнерот
        mRecyclerView = (RecyclerView) findViewById(R.id.my_reservations_list);

        // оваа карактеристика може да се користи ако се знае дека промените
        // во содржината нема да ја сменат layout големината на RecyclerView
//        mRecyclerView.setHasFixedSize(true);

        // ќе користиме LinearLayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // и default animator (без анимации)
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // сетирање на кориснички дефиниран адаптер myAdapter (посебна класа)
        mAdapter = new MyReservationAdapter(myReservations, R.layout.my_reservations_row, this);

        //прикачување на адаптерот на RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }


}
