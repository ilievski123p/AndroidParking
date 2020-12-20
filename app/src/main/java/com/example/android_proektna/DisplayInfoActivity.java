package com.example.android_proektna;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class DisplayInfoActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    myAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        List<String> values = Arrays.asList("Скопје", "Охрид", "Пробиштип",
                "Кратово", "Пехчево", "Струга", "Берово", "Крива Паланка",
                "Куманово", "Струмица");

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
        mAdapter = new myAdapter(values, R.layout.my_row, this);

        //прикачување на адаптерот на RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }
    public void onClick(View view) {
        Intent form_intent = new Intent(this, RegisterFormActivity.class);
        startActivity(form_intent);

    }
}
