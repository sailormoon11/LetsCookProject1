package com.julia_sk.favorite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {

    DB db = new DB();

    Button button;
    Button category;
    Button favorite;
    Button random;
    TextView version;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.button);
        category = (Button) findViewById(R.id.category);
        favorite = (Button) findViewById(R.id.favorite);
        random = (Button) findViewById(R.id.random);
        version = (TextView) findViewById(R.id.version) ;
        version.setText(Version.version);
        button.setOnClickListener(this);
        category.setOnClickListener(this);
        favorite.setOnClickListener(this);
        random.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                Main2Activity.setLessonsList(db.allRecipes);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.category:
                intent = new Intent(this,Category.class);
                startActivity(intent);
                break;
            case R.id.favorite:
                //Main2Activity.setLessonsList(db.favoriteList);
                intent = new Intent(this,FavoriteActivity.class);
                startActivity(intent);
                break;
            case R.id.random:
                ArrayList<Recipe> rand= new ArrayList<Recipe>();
                rand.add(db.allRecipes.get(new Random().nextInt(db.allRecipes.size())));
                Main2Activity.setLessonsList(rand);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;


        }
    }

}

