package com.julia_sk.favorite;

import android.app.Activity;

/**
 * Created by Юлия on 05.12.2016.
 */

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RecipeActivity extends Activity{

    private Recipe recipe;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        if (getIntent() != null) {
            position = getIntent().getIntExtra("position", -1);
        }
        recipe = Main2Activity.recipeList.get(position);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(recipe.getText());

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem fave = menu.findItem(R.id.menu_item_is_favorite);
        MenuItem unfave = menu.findItem(R.id.menu_item_no_favorite);

        if (recipe != null) {
            fave.setVisible(recipe.isFavorite());
            unfave.setVisible(!recipe.isFavorite());
        } else {
            fave.setVisible(false);
            unfave.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item_no_favorite:
                setFavorite(true);
                return true;

            case R.id.menu_item_is_favorite:
                setFavorite(false);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void setFavorite(boolean isFavorite) {
        recipe.setFavorite(isFavorite);
        invalidateOptionsMenu();
    }

}