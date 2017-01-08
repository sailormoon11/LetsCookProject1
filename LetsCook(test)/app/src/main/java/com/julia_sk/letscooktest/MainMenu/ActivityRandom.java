package com.julia_sk.letscooktest.MainMenu;

import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;
import com.julia_sk.letscooktest.R;

import java.util.Random;

import static com.julia_sk.letscooktest.R.layout.random;

/**
 * Created by Юлия on 23.11.2016.
 */

public class ActivityRandom extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( random);
        String[] recipes = {"Рецепт1", "Рецепт2", "Рецепт3"};
        Random r = new Random();
        TextView textView = (TextView) findViewById(R.id.textViewRand);
        textView.setText(recipes[r.nextInt(recipes.length)]);
    }
}
