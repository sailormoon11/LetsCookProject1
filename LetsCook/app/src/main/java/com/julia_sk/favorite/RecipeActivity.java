package com.julia_sk.favorite;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Юлия on 05.12.2016.
 */

public class RecipeActivity extends Activity{

    private Recipe recipe;
    private int position = 0;
    final int MENU_FAVORITE = 1;
    final int MENU_FAVORITE_DEL = 2;

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
        registerForContextMenu(textView);

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
                DB.save(recipe);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Рецепт добавлен в избранное",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;

            case R.id.menu_item_is_favorite:
                setFavorite(false);
                DB.delete(recipe);
                Toast toast2 = Toast.makeText(getApplicationContext(),
                        "Рецепт удален из избранного",
                        Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.CENTER, 0, 0);
                toast2.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.textView:
                if (!recipe.isFavorite())
                    menu.add(0, MENU_FAVORITE, 0, "Добавить в изобранное");
                else
                    menu.add(1, MENU_FAVORITE_DEL, 1, "Удалить из избранного");

                break;
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_FAVORITE:
                DB.save(recipe);
                break;
            case MENU_FAVORITE_DEL:
                DB.delete(recipe);
                break;
        }
        return super.onContextItemSelected(item);
    }
    void setFavorite(boolean isFavorite) {
        recipe.setFavorite(isFavorite);
        invalidateOptionsMenu();
    }

}