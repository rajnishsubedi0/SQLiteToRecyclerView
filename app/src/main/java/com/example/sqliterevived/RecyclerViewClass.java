package com.example.sqliterevived;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewClass extends RecyclerView.Adapter<RecyclerViewClass.myCustomViewHolder>{
    
    ArrayList<DataHolder> arrayList;
    public RecyclerViewClass(ArrayList<DataHolder> arrayList){
        this.arrayList=arrayList;
    }

    public class myCustomViewHolder extends RecyclerView.ViewHolder{
        TextView textNameFromRecyclerLayout,textAddressFromRecyclerLayout;
        public myCustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textNameFromRecyclerLayout=itemView.findViewById(R.id.textNameFromRecyclerLayout);
            this.textAddressFromRecyclerLayout=itemView.findViewById(R.id.textAddressFromRecyclerLayout);

        }
    }

    @NonNull
    @Override
    public RecyclerViewClass.myCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCustomView=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new myCustomViewHolder(myCustomView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewClass.myCustomViewHolder holder, int position) {

        holder.textNameFromRecyclerLayout.setText(arrayList.get(holder.getAdapterPosition()).getName());
        holder.textAddressFromRecyclerLayout.setText(arrayList.get(holder.getAdapterPosition()).getName());
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }
}


