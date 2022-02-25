package com.example.recimagedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    MyRecyclerViewAdapter adapter;

    ArrayList text = new ArrayList<>(Arrays.asList("Person 1","Person 2","Person 3","Person 4","Person 5","Person 6","Person 7","Person 8","Person 9"));
    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.person1,R.drawable.person2,R.drawable.person3,R.drawable.person4,R.drawable.person5,R.drawable.person1,R.drawable.person2,R.drawable.person3,R.drawable.person4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the reference of recyclerview
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        //Setting the layout as staggered grid for verticle orientation

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        //sending reference and data to adapter
        adapter = new MyRecyclerViewAdapter(MainActivity.this,images,text);

        //setting adapter to recycle view
        recyclerView.setAdapter(adapter);

    }
}