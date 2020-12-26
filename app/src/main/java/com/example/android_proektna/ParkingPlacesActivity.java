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
public class ParkingPlacesActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ParkingPlaceAdapter mAdapter;
    TextView dateText;
    TextView numberHours;
    TextView cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_places_activity);
        dateText = (TextView) findViewById(R.id.chosen_date_parking);
        numberHours = (TextView) findViewById(R.id.number_of_hours);
        cityName = (TextView) findViewById(R.id.city_name_parking_activity);

        Intent incoming = getIntent();
         City city = incoming.getParcelableExtra("city");
        int day = incoming.getIntExtra("day", 0);
        int month = incoming.getIntExtra("month", 0);
        int year = incoming.getIntExtra("year", 0);
        String hours = incoming.getStringExtra("hours");
        String date = day + "/" + month + "/" + year;

        assert city != null;
        String city_name = city.getName();

        hours = hours + " hours";
        date = "Reservation for " + date;

        dateText.setText(date);
        numberHours.setText(hours);
        cityName.setText(city_name);


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
        mAdapter = new ParkingPlaceAdapter(city.getParkings(), R.layout.parking_places_card_activity, this);

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