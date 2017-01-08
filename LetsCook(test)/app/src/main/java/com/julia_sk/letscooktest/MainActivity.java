package com.julia_sk.letscooktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import com.julia_sk.letscooktest.MainMenu.ActivityElect;
import com.julia_sk.letscooktest.MainMenu.ActivityFilters;
import com.julia_sk.letscooktest.MainMenu.ActivityRandom;
import com.julia_sk.letscooktest.MainMenu.ActivitySearch;
import com.julia_sk.letscooktest.MainMenu.ActivityStock;
import com.julia_sk.letscooktest.SearchMenu.ActivityMeat;


public class MainActivity extends Activity implements View.OnClickListener {

    String[] resipes = {"Рецепт1", "Рецепт2", "Рецепт3"};
    Button btnSearch;
    Button btnFilters;
    Button btnStock;
    Button btnRandom;
    Button btnElect;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView versionView = (TextView)findViewById(R.id.versionView);
        versionView.setText("Version: " + Version.version);

        btnSearch = (Button) findViewById( R.id.btnSearch);
        btnSearch.setOnClickListener(this);

        btnFilters = (Button) findViewById(R.id.btnFilters);
        btnFilters.setOnClickListener(this);

        btnStock = (Button) findViewById(R.id.btnStock);
        btnStock.setOnClickListener(this);

        btnRandom = (Button) findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(this);

        btnElect = (Button) findViewById(R.id.btnElect);
        btnElect.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearch:
                Intent intent1 = new Intent(this, ActivitySearch.class);
                startActivity(intent1);
                break;
            case R.id.btnFilters:
                Intent intent = new Intent(this, ActivityFilters.class);
                startActivity(intent);
                break;
            case R.id.btnStock:
                Intent intent2 = new Intent(this, ActivityStock.class);
                startActivity(intent2);
                break;
            case R.id.btnRandom:
                Intent intent3 = new Intent(this, ActivityRandom.class);
                startActivity(intent3);
                break;
            case R.id.btnElect:
                Intent intent4 = new Intent(this, ActivityElect.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}
