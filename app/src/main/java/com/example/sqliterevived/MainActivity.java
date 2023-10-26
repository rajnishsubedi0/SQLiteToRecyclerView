package com.example.sqliterevived;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editName, editAddress;
    Button buttonAddData,buttonStartIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=findViewById(R.id.editName);
        editAddress=findViewById(R.id.editAddress);
        buttonAddData=findViewById(R.id.buttonAddData);
        buttonStartIntent=findViewById(R.id.buttonStartActivityIntent);
        DbHelperClass dbHelperClass=new DbHelperClass(MainActivity.this);

        buttonAddData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name=editName.getText().toString();
                String  address=editAddress.getText().toString();
                if (name.isEmpty() || address.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please input in all field", Toast.LENGTH_SHORT).show();
                }
                else{
                    dbHelperClass.addData(name,address);
                    Toast.makeText(MainActivity.this, "Data has been added", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonStartIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), RetriveMainActivity.class);
                startActivity(intent);
            }
        });

    }
}