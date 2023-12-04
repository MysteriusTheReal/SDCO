package com.example.sdco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void bt(View view){
        Intent i=new Intent(MainActivity2.this, ls.class);
        startActivity(i);
    }
    public  void bt2 (View view){
        Intent i=new Intent(MainActivity2.this, ld.class);
        startActivity(i);
    }
    public void bt3(View view){
        Intent i=new Intent(MainActivity2.this, lc.class);
        startActivity(i);
    }
    public void bt4(View view){

        Intent i=new Intent(MainActivity2.this, mo.class);
        startActivity(i);
    }
}