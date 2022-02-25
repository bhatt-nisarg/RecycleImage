package com.example.recimagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    ImageView viewImage;
    TextView viewtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //Init a ImageView
        viewImage = findViewById(R.id.showimage);
        viewtext = findViewById(R.id.showtext);
        //get intent from my recyclerview
        Intent intent = getIntent();
        //get image from intent and set it into imageview
        viewImage.setImageResource(intent.getIntExtra("image",0));
        viewtext.setText(intent.getStringExtra("text"));



    }
}