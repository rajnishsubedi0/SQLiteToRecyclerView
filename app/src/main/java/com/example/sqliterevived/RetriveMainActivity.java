package com.example.sqliterevived;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class RetriveMainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewClass recyclerViewHandlingClass;
    DbHelperClass dbHelperClass;
    ArrayList<DataHolder> arrayListDataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_main);
        recyclerView=findViewById(R.id.recyclerView);
        arrayListDataHolder=new ArrayList<DataHolder>();
        dbHelperClass=new DbHelperClass(getApplicationContext());


        setData();

}

    private void setData() {
        arrayListDataHolder=dbHelperClass.getDataFromDb();
        setAdapter();
    }

    private void setAdapter() {
    recyclerViewHandlingClass=new RecyclerViewClass(arrayListDataHolder);
    RecyclerView.LayoutManager myLayoutManager=new LinearLayoutManager(RetriveMainActivity.this );
    recyclerView.setLayoutManager(myLayoutManager);
    recyclerView.setAdapter(recyclerViewHandlingClass);
    }
}