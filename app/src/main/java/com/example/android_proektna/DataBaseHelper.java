package com.example.android_proektna;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android_proektna.models.City;
import com.example.android_proektna.models.Parking;
import com.example.android_proektna.models.Reservation;

import java.util.ArrayList;

import static com.example.android_proektna.LoginDatabaseAdapter.DATABASE_NAME;

public class DataBaseHelper extends SQLiteOpenHelper {
    private final String dbPath;
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;

        dbPath = "data/user/0/" + context.getPackageName() + "/databases/";
    }

    Context context;
    @Override
    public void onCreate(SQLiteDatabase _db) {
        try {
            _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATE);
            _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATE_second);
            _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATE_third);
            _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATE_fourth);

            DataBaseHelper dbHelper = new DataBaseHelper(context);

            //SeedData for Parking
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Katna Garaza', 120, 80, 'Skopje', 41.989594042453184, 21.4322579844686 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('City Mall', 250, 50, 'Skopje', 42.00486821998738, 21.39151159474436 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('SD Goce Delcev', 340, 10, 'Skopje', 42.00048321234534, 21.3898825235622356 )");

            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('GOBI', 150, 99, 'Probistip', 41.99735225739181, 22.18409832137044 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Sekundaren Plostad', 25, 10, 'Probistip', 42.00105596824093, 22.17884449262904 )");

            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('OKI KOM', 34, 99, 'Kratovo', 42.07848704853099, 22.17574073514983 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Plostad', 30, 10, 'Kratovo', 42.07864525792858, 22.180594113177943 )");

            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('EMUC', 54, 29, 'Stip', 41.747735420831376, 22.181993460021367 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Ednonasocna', 12, 2, 'Stip', 41.73790177483657, 22.193075975573766 )");

            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Kej', 77, 69, 'Ohrid', 41.11936359401521, 20.783933294956 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Plostad', 345, 36, 'Ohrid', 41.12235803338885, 20.781998575682596 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Ljubaniste', 344, 123, 'Ohrid', 40.921391505033185, 20.760143334842027 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Partizan', 533, 73, 'Ohrid', 41.12018509100847, 20.781734750328884 )");

            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Plostad', 66, 23, 'Kavadarci', 41.43377806876674, 22.011033530931872 )");
            _db.execSQL("INSERT INTO " + "Parking" + "(NAME, PARKINGPLACES, FREEPLACES, CITY, LAT, LNG ) VALUES ('Pazar', 354, 35, 'Kavadarci', 41.44116412035752, 22.01074606349392 )");


            //SeedData for City
            _db.execSQL("INSERT INTO " + "City" + "(NAME, IMAGE, PARKINGS ) VALUES ('Skopje',1 , 'Yes' )");
            _db.execSQL("INSERT INTO " + "City" + "(NAME, IMAGE, PARKINGS ) VALUES ('Probistip', 2, 'Yes' )");
            _db.execSQL("INSERT INTO " + "City" + "(NAME, IMAGE, PARKINGS ) VALUES ('Kratovo', 3, 'Yes' )");
            _db.execSQL("INSERT INTO " + "City" + "(NAME, IMAGE, PARKINGS ) VALUES ('Stip', 4, 'Yes' )");
            _db.execSQL("INSERT INTO " + "City" + "(NAME, IMAGE, PARKINGS ) VALUES ('Ohrid', 5, 'Yes' )");
            _db.execSQL("INSERT INTO " + "City" + "(NAME, IMAGE, PARKINGS ) VALUES ('Kavadarci', 6, 'Yes' )");


        }catch(Exception er){

            Log.e("Error","exception");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");
        _db.execSQL("DROP TABLE IF EXISTS " + "LOGIN");
        _db.execSQL("DROP TABLE IF EXISTS " + "CITY");
        _db.execSQL("DROP TABLE IF EXISTS " + "PARKING");
        onCreate(_db);
    }

    public ArrayList<City> getCities(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<City> cities = new ArrayList<City>();
        String query = String.format("SELECT * FROM City");
        Cursor cursor = db.rawQuery(query, null);
        int i=0;
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int image = 0;
                String name = cursor.getString(1);
                if (name.equals("Skopje"))
                 image = R.drawable.skopje;
                if (name.equals("Probistip"))
                    image = R.drawable.probistip;
                if (name.equals("Kratovo"))
                    image = R.drawable.kratovo;
                if (name.equals("Stip"))
                    image = R.drawable.stip;
                if (name.equals("Kavadarci"))
                    image = R.drawable.kavadarci;
                if (name.equals("Ohrid"))
                    image = R.drawable.ohrid;
                String parking = cursor.getString(2);
                City pom = new City(name, image, parking);
                cities.add(i, pom);
                i++;
            } while (cursor.moveToNext());
        }
        return cities;
    }
    public ArrayList<Parking> getParkings(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Parking> parking = new ArrayList<Parking>();
        Cursor cursor = db.rawQuery( "Select * from parking where city=?  ", new String[]{name});
        int i=0;
        if (cursor != null && cursor.moveToFirst()) {
            do {
                    String p_name = cursor.getString(1);
                    int p_places = cursor.getInt(2);
                    int f_places = cursor.getInt(3);
                    String city = cursor.getString(4);
                    String lat = cursor.getString(5);
                    String lng = cursor.getString(6);
                    Parking pom = new Parking(p_name, p_places, f_places, city, lat, lng);
                    parking.add(i, pom);
                    i++;
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return parking;
    }
    public ArrayList<Reservation> getReservations(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Reservation> reservation = new ArrayList<Reservation>();
        Cursor cursor = db.query("myReservations", null, null,
                null, null, null, "ID" + " DESC", null);
        int i=0;
        if (cursor != null && cursor.moveToFirst()) {
            do {
                    String cityname = cursor.getString(1);
                    String parkingname = cursor.getString(2);
                    String hour = cursor.getString(3);
                    String date = cursor.getString(4);
                    Reservation pom = new Reservation(cityname,parkingname,hour,date);
                    reservation.add(i,pom);
                    i++;
            }
            while (cursor.moveToNext());
        }
        return reservation;
    }


}