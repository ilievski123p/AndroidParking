package com.example.android_proektna;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_proektna.models.City;
import com.example.android_proektna.models.Parking;

import java.util.ArrayList;

public class ParkingPlaceAdapter extends RecyclerView.Adapter<ParkingPlaceAdapter.ViewHolder>{

    private ArrayList<Parking> myList;
    private int rowLayout;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mName;
        public Button freePlaces;
        public Button takenPlaces;
        public Button buttonReserve;

        public ViewHolder( View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.parking_name);
            freePlaces = (Button) itemView.findViewById(R.id.free_places);
            takenPlaces = (Button) itemView.findViewById(R.id.taken_places);
            buttonReserve = (Button) itemView.findViewById(R.id.button_reserve);
        }
    }

    public ParkingPlaceAdapter(ArrayList<Parking> parkingsList, int rowLayout, Context context) {
        this.myList = parkingsList;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Parking entry = myList.get(position);
        holder.mName.setText(entry.getParkingName());
        String taken = String.valueOf(entry.getTakenPlaces());
        taken = taken;
        String free = String.valueOf(entry.getFreePlaces());
        free = free;
        holder.takenPlaces.setText(taken);
        holder.freePlaces.setText(free);


        holder.buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ConfirmReservation.class);
                intent.putExtra("parking", myList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }

}
