package com.example.hasantarek.materialdesign_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int []images = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6};
    String name[];
    String actor[];
    String email[];
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Moviedataprovider> arrayList = new ArrayList<Moviedataprovider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_id);
        name = getResources().getStringArray(R.array.name);
        actor = getResources().getStringArray(R.array.actor);
        email = getResources().getStringArray(R.array.email);

        int count=0;
        for(String Mname : name)
        {
            Moviedataprovider moviedataprovider = new Moviedataprovider(Mname,email[count],actor[count],images[count]);
            count++;
            arrayList.add(moviedataprovider);
        }

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);


    }
}
