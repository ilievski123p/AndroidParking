package com.example.android_proektna;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android_proektna.models.City;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<com.example.android_proektna.myAdapter.ViewHolder> {

    private List<City> myList;
    private int rowLayout;
    private Context mContext;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView myName;
        public ImageView Pic;

        public ViewHolder(View itemView) {
            super(itemView);
            myName = (TextView) itemView.findViewById(R.id.Name);
            Pic = (ImageView) itemView.findViewById(R.id.picture);
        }
    }

    // конструктор
    public myAdapter(ArrayList<City> myList, int rowLayout, Context context) {
        this.myList = myList;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    // Креирање нови views (повикано од layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    // Замена на содржината во view (повикано од layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        City entry = myList.get(i);
        viewHolder.Pic.setImageResource(entry.getImage());
        viewHolder.myName.setText(entry.getName());
        viewHolder.myName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RegisterFormActivity.class);
                intent.putExtra("city", myList.get(i));
                mContext.startActivity(intent);
            }
        });
    }

    // Пресметка на големината на податочното множество (повикано од layout manager)
    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }

}
