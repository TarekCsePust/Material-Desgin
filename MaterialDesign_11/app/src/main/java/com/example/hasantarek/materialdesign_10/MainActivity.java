package com.example.hasantarek.materialdesign_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    boolean is_action_mode = false;
    TextView counter_text;
    int []images = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6};
    String name[];
    String actor[];
    String email[];
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Moviedataprovider> arrayList = new ArrayList<Moviedataprovider>();
    Toolbar toolbar;
    ArrayList<Moviedataprovider> selectList = new ArrayList<>();
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_id);
        counter_text = (TextView)findViewById(R.id.counter_id);
        name = getResources().getStringArray(R.array.name);
        actor = getResources().getStringArray(R.array.actor);
        email = getResources().getStringArray(R.array.email);
        counter_text.setVisibility(View.GONE);
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
        adapter = new RecyclerAdapter(arrayList,MainActivity.this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onLongClick(View v) {
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_action_mode);
        counter_text.setVisibility(View.VISIBLE);
        is_action_mode = true;
        adapter.notifyDataSetChanged();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    public void preparselection(View view,int position)
    {
        if(((CheckBox)view).isChecked())
        {
            selectList.add(arrayList.get(position));
            counter++;
            updateCounter(counter);
        }
        else
        {
            selectList.remove(arrayList.get(position));
            counter--;
            updateCounter(counter);
        }
    }

    public void updateCounter(int count)
    {
        if(count == 0)
        {
            counter_text.setText("0 item selected");
        }
        else
        {
            counter_text.setText(count + " item selected");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_id)
        {

            RecyclerAdapter recyclerAdapter = (RecyclerAdapter) adapter;
            recyclerAdapter.updateAdapter(selectList);
            clearActionMode();
        }
        else
        if(item.getItemId() == android.R.id.home)
        {
            clearActionMode();
            adapter.notifyDataSetChanged();
        }
        return true;
    }

    public  void  clearActionMode()
    {
        is_action_mode = false;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.main_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        counter_text.setVisibility(View.GONE);
        counter_text.setText("0 item selected");
        counter = 0;
        selectList.clear();
    }

    @Override
    public void onBackPressed() {
        if(is_action_mode)
        {
            clearActionMode();
            adapter.notifyDataSetChanged();
        }else
        {
            super.onBackPressed();
        }

    }

}
