package com.julia_sk.favorite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category extends Activity implements View.OnClickListener{
//    public static ArrayList<Recipe> recipeList;
//    public static ArrayList<Recipe> recipeList2;
    DB db = new DB();
    Button category1;
    Button category2;
    Button milk;
    Button fruit;
    Button macarons;
    Button semimanufactures;
    Button other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        category1 = (Button) findViewById(R.id.category1);
        category2 = (Button) findViewById(R.id.category2);
        milk = (Button) findViewById(R.id.btnMilk);
        fruit = (Button) findViewById(R.id.btnFruits);
        macarons = (Button) findViewById(R.id.btnMacarons);
        semimanufactures = (Button) findViewById(R.id.btnSemimanufactures);
        other = (Button) findViewById(R.id.btnOther);
        category1.setOnClickListener(this);
        category2.setOnClickListener(this);
        milk.setOnClickListener(this);
        fruit.setOnClickListener(this);
        macarons.setOnClickListener(this);
        semimanufactures.setOnClickListener(this);
        other.setOnClickListener(this);
//        db.recipeList = new ArrayList<Recipe>();
//        db.recipeList2 = new ArrayList<Recipe>();

//        for (int i = 1; i < 11; i++) {
//            recipeList.add(new Recipe("Урок " + i, "Текст урока номер " + i+ ". В этом уроке мы научимся ..."));
//        }
//        for (int i = 1; i < 11; i++) {
//            recipeList2.add(new Recipe("Рецепт " + i, "Текст урока номер " + i+ ". В этом уроке мы научимся ..."));
//        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.category1:
                Main2Activity.setRecipeList(db.recipeList);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.category2:
                Main2Activity.setRecipeList(db.recipeList2);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btnMilk:
                Main2Activity.setRecipeList(db.milk);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btnFruits:
                Main2Activity.setRecipeList(db.Fruits);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btnMacarons:
                Main2Activity.setRecipeList(db.Macarons);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btnOther:
                Main2Activity.setRecipeList(db.Other);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btnSemimanufactures:
                Main2Activity.setRecipeList(db.Semimanufactures);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
