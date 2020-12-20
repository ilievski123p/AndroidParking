package com.example.android_proektna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<com.example.android_proektna.myAdapter.ViewHolder> {

    private List<String> myList;
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
    public myAdapter(List<String> myList, int rowLayout, Context context) {
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
        String entry = myList.get(i);
        viewHolder.myName.setText(entry);
        viewHolder.myName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                Toast.makeText(mContext, tv.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Пресметка на големината на податочното множество (повикано од layout manager)
    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }

}
