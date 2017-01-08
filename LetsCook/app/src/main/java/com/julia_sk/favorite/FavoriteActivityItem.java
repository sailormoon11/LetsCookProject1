package com.julia_sk.favorite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FavoriteActivityItem extends Activity {

    private Recipe recipe;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_item);
        if (getIntent() != null) {
            position = getIntent().getIntExtra("position", -1);
        }
        TextView textView = (TextView) findViewById(R.id.favoriteView);
        if (!(DB.favoriteList == null)) {
            recipe = DB.favoriteList.get(position);
            textView.setText(recipe.getText());
        }
        else {
            textView.setText("Список пуст");
        }
    }
}



