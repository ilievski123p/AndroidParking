package com.example.android_proektna;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_proektna.models.Parking;

public class ConfirmReservation extends AppCompatActivity {

    TextView parkingName;
    Button navigate;
    Button openMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reservation);

        parkingName = (TextView) findViewById(R.id.chosen_parking_name);
        navigate = (Button) findViewById(R.id.button_navigate);
        openMap = (Button) findViewById(R.id.button_open_map);

        Intent incoming = getIntent();
        Parking parking = incoming.getParcelableExtra("parking");
        String name = parking.getParkingName();

        final String lat = parking.getLat();
        final String lng = parking.getLng();

        parkingName.setText(name);

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=" + lat + "," + lng + "&model=d"));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
               // intent.putExtra("parking", parking);
                //startActivity(intent);
            }
        });
    }
}