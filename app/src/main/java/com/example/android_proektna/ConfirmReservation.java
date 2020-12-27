package com.example.android_proektna;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.android_proektna.models.Parking;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;

public class ConfirmReservation extends AppCompatActivity {

    TextView parkingName;
    Button navigate;
    ImageView qrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reservation);

        parkingName = (TextView) findViewById(R.id.chosen_parking_name);
        navigate = (Button) findViewById(R.id.button_navigate);
        Intent incoming = getIntent();
        Parking parking = incoming.getParcelableExtra("parking");
        String name = parking.getParkingName();

        final String lat = parking.getLat();
        final String lng = parking.getLng();
        qrImage = (ImageView) findViewById(R.id.qrCode);
        parkingName.setText(name);
        Uri data = Uri.parse("google.navigation:q=" + lat + "," + lng + "&model=d");

        QRGEncoder qrgEncoder = new QRGEncoder(data.toString(), null, QRGContents.Type.TEXT,500);
        qrgEncoder.setColorBlack(Color.BLUE);
        qrgEncoder.setColorWhite(Color.WHITE);
        Bitmap bitmap;
        // Getting QR-Code as Bitmap
        bitmap = qrgEncoder.getBitmap();
        // Setting Bitmap to ImageView
        qrImage.setImageBitmap(bitmap);

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=" + lat + "," + lng + "&model=d"));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
    }
    public void Download(){

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