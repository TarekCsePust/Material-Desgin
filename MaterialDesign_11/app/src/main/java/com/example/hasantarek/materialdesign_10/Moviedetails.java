package com.example.hasantarek.materialdesign_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Moviedetails extends AppCompatActivity {

    TextView movie_name,actor_name,email_add;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetails);
        movie_name = (TextView)findViewById(R.id.dmovie_id);
        actor_name = (TextView)findViewById(R.id.dactor_id);
        email_add = (TextView)findViewById(R.id.demail_id);
        imageView = (ImageView)findViewById(R.id.dimage_id);
        Intent intent = getIntent();
        imageView.setImageResource(intent.getIntExtra("image",00));
        movie_name.setText("Movie name: " + intent.getStringExtra("mov_name"));
        actor_name.setText("Actor name: " + intent.getStringExtra("actor_name"));
        email_add.setText("Email Address: " + intent.getStringExtra("email_add"));



    }
}
