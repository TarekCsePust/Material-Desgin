package com.example.hasantarek.matireladesign_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int res_id = item.getItemId();
        switch (res_id)
        {
            case R.id.setting:
                Toast.makeText(MainActivity.this,"setting",Toast.LENGTH_LONG).show();
                break;
            case R.id.alarm:
                Toast.makeText(MainActivity.this,"alarm",Toast.LENGTH_LONG).show();
                break;
            case R.id.contact:
                Toast.makeText(MainActivity.this,"contact",Toast.LENGTH_LONG).show();
                break;
            case R.id.message:
                Toast.makeText(MainActivity.this,"message",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }
}
