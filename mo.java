package com.example.sdco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo);
    }
    public void burbuja(View view){
        Intent i =new Intent(this, burbuja.class);
        startActivity(i);
    }
    public void wit(View view){
        Intent i =new Intent(this, wit.class);
        startActivity(i);
    }
}