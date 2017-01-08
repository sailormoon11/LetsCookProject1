package com.julia_sk.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FavoriteActivity extends Activity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        setContentView(R.layout.activity_favorite);
        DB.setFavoritrList2();
        ListView lFavorite = (ListView) findViewById(R.id.lfavorite);

        context = this;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,DB.favoriteString);

        lFavorite.setAdapter(adapter);

        lFavorite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,FavoriteActivityItem.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
    }
}
