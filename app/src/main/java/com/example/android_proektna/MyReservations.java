package com.example.android_proektna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MyReservations extends AppCompatActivity {
    private Context context;
    RecyclerView mRecyclerView;
    myAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_places_activity);
        List<String> values = Arrays.asList("Холидеј Ин", "Сити Мол", "ГТЦ",
                "Рамсторе");

        //сетирање на RecyclerView контејнерот
        mRecyclerView = (RecyclerView) findViewById(R.id.list);

        // оваа карактеристика може да се користи ако се знае дека промените
        // во содржината нема да ја сменат layout големината на RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // ќе користиме LinearLayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // и default animator (без анимации)
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // сетирање на кориснички дефиниран адаптер myAdapter (посебна класа)
      //  mAdapter = new myAdapter(values, R.layout.my_reservations_row, this);

        //прикачување на адаптерот на RecyclerView
        mRecyclerView.setAdapter(mAdapter);
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
