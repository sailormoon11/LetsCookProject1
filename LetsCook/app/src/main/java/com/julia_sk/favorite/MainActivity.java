package com.julia_sk.favorite;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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
    Button search;
    TextView version;

    DB1 db1 = new DB1(this);
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        search = (Button) findViewById((R.id.search));
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
        search.setOnClickListener(this);
        DB.recipeList = new ArrayList<Recipe>();
        DB.recipeList2 = new ArrayList<Recipe>();
        DB.allRecipes = new ArrayList<Recipe>();
        DB.Macarons = new ArrayList<Recipe>();
        DB.Fruits = new ArrayList<Recipe>();
        DB.milk = new ArrayList<Recipe>();
        DB.Other = new ArrayList<Recipe>();
        DB.Semimanufactures = new ArrayList<Recipe>();
        db1.open();
      //

        //cursor = db1.getFilter(filter);
        cursor = db1.getAllData();
        DB.setList(cursor,DB.allRecipes);
        cursor = db1.getORFilter(new String[]{"мясо"});
        DB.setList(cursor,DB.recipeList);
        cursor = db1.getORFilter(new String[] {"рыба"});
        DB.setList(cursor,DB.recipeList2);
        cursor = db1.getORFilter(new String[] {"капуста","картошкка", "помидор", "огурец"});
        DB.setList(cursor,DB.Fruits);
        cursor = db1.getORFilter(new String[] {"макароны"});
        DB.setList(cursor,DB.Macarons);
        cursor = db1.getORFilter(new String[] {"молоко","cыр", "сметана"});
        DB.setList(cursor,DB.milk);
        cursor = db1.getORFilter(new String[] {"яйцо","томатная паста"});
        DB.setList(cursor,DB.Other);
        cursor = db1.getORFilter(new String[] {"бичпакет"});
        DB.setList(cursor,DB.Semimanufactures);
        cursor.close();

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:

                Main2Activity.setRecipeList(db.allRecipes);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.category:
                intent = new Intent(this,Category.class);
                startActivity(intent);
                break;
            case R.id.favorite:
                if (db.favoriteList==null) {
                    //TextView textView1 = (TextView) findViewById(R.id.notFavorite);
                   // textView1.setText("Список пуст");
                    db.favoriteList = new ArrayList<Recipe>();
                }
                Main2Activity.setRecipeList(db.favoriteList);
                intent = new Intent(this,Main2Activity.class);
                //intent = new Intent(this,FavoriteActivity.class);
                startActivity(intent);
                break;
            case R.id.random:
                ArrayList<Recipe> rand= new ArrayList<Recipe>();
                rand.add(db.allRecipes.get(new Random().nextInt(db.allRecipes.size())));
                Main2Activity.setRecipeList(rand);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.search:
                intent = new Intent(this,Activity_Products.class);
                startActivity(intent);
                break;


        }
    }

}

