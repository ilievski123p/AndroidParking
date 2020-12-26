package com.example.android_proektna;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_proektna.models.City;
import com.example.android_proektna.models.Parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayInfoActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    myAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        ArrayList<City> cities = new ArrayList<>();
        ArrayList<Parking> skopje = new ArrayList<>();
        ArrayList<Parking> bitola = new ArrayList<>();
        ArrayList<Parking> ohrid = new ArrayList<>();
        ArrayList<Parking> kumanovo = new ArrayList<>();
        ArrayList<Parking> kicevo = new ArrayList<>();
        ArrayList<Parking> prilep = new ArrayList<>();
        ArrayList<Parking> strumica = new ArrayList<>();
        ArrayList<Parking> struga = new ArrayList<>();
        ArrayList<Parking> veles = new ArrayList<>();
        ArrayList<Parking> gevgelija = new ArrayList<>();


        skopje.add(new Parking("Skopje City Mall", 300, 120, "Skopje", "42.00492991775837", "21.391735808202956"));
        skopje.add(new Parking("Ramstore Mall", 200, 130, "Skopje", "41.991922973379225", "21.427919309629456"));
        cities.add(new City("Скопје", R.drawable.skopje, skopje));

        bitola.add(new Parking("Sportska Sala Parking", 200, 30, "Bitola", "41.0227835298321", "21.33663881479847"));
        bitola.add(new Parking("Shirok Sokak", 50, 15, "Bitola", "41.03111786084998", "21.33623121172701"));
        cities.add(new City("Битола", R.drawable.bitola, bitola));

        ohrid.add(new Parking("Parking Pristaniste", 200, 180, "Ohrid", "41.11259402722531", "20.799428875675396"));
        ohrid.add(new Parking("Parking Plazi", 100, 35, "Ohrid", "41.10280214528415", "20.807460554680524"));
        cities.add(new City("Охрид", R.drawable.ohrid, ohrid));

        kumanovo.add(new Parking("Sokolana Parking", 80, 75, "Kumanovo", "42.1291047307248", "21.719541674282006"));
        cities.add(new City("Куманово", R.drawable.kumanovo, kumanovo));

        kicevo.add(new Parking("Parking Osnoven Sud", 50, 25, "Kicevo", "41.51251662927505", "20.959971852516848"));
        cities.add(new City("Кичево", R.drawable.kicevo, kicevo));

        prilep.add(new Parking("Parking Centar", 200, 120, "Prilep", "41.34556484188022", "21.552453230157727"));
        prilep.add(new Parking("Katna Garaza", 150, 120, "Prilep", "41.34380408233429", "21.551862938884636"));
        cities.add(new City("Прилеп", R.drawable.prilep, prilep));

        strumica.add(new Parking("Global Parking", 300, 70, "Strumica", "41.43969248241463", "22.63999400970511"));
        cities.add(new City("Струмица", R.drawable.strumica, strumica));

        struga.add(new Parking("Hotel Drim Parking", 200, 150, "Struga", "41.17361811795702", "20.680311736910248"));
        cities.add(new City("Струга", R.drawable.struga, struga));

        veles.add(new Parking("Parking Gimnazija", 300, 120, "Veles", "41.71816684336158", "21.77288032521455"));
        cities.add(new City("Велес", R.drawable.veles, veles));

        gevgelija.add(new Parking("Gradski Pazar Parking", 100, 30, "Gevgelija", "41.14255626997016", "22.493835722781025"));
        cities.add(new City("Гевгелија", R.drawable.gevgelija, gevgelija));

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
        mAdapter = new myAdapter(cities, R.layout.my_row, this);

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
