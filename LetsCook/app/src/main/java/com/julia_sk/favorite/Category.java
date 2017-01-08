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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        category1 = (Button) findViewById(R.id.category1);
        category2 = (Button) findViewById(R.id.category2);
        category1.setOnClickListener(this);
        category2.setOnClickListener(this);
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
                Main2Activity.setLessonsList(db.recipeList);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.category2:
                Main2Activity.setLessonsList(db.recipeList2);
                intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;

        }
    }
}
