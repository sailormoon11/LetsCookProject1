package com.julia_sk.favorite;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity_Products extends Activity implements OnClickListener {

    ListView lvProducts;
    String[] arrayProducts;
    ArrayList<String> alProducts;
    ArrayList<Integer> alPositions;
    TinyDB tinyDB;
    String[] filter;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        lvProducts = (ListView) findViewById(R.id.lvProducts);
        lvProducts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrayProducts, android.R.layout.simple_list_item_multiple_choice);
        lvProducts.setAdapter(adapter);

        Button btnChecked = (Button) findViewById(R.id.btnOk);
        btnChecked.setOnClickListener(this);
        tinyDB = new TinyDB(this);
        ArrayList<Integer> positions = new ArrayList<Integer>();
        positions = tinyDB.getListInt("tinyDBPositions");
        for(int i : positions)
        {
            lvProducts.setItemChecked(i, true);
        }

        arrayProducts = getResources().getStringArray(R.array.arrayProducts);
    }

    public void onClick(View arg0) {
        alProducts = new ArrayList<String>();
        alPositions = new ArrayList<Integer>();
        SparseBooleanArray sbArray = lvProducts.getCheckedItemPositions();
        int key;

        for (int i = 0; i < sbArray.size(); i++) {
            key = sbArray.keyAt(i);
            if (sbArray.get(key))
            {
                alProducts.add(arrayProducts[key]);
                alPositions.add(key);
            }
            else {
                if (alPositions.contains((Object)(key))) {
                    alProducts.remove((Object)(arrayProducts[key]));
                    alPositions.remove((Object) key);
                }
            }
        }
        for (int i = 0; i < alProducts.size(); i++) {
            Log.d("log",alProducts.get(i));
        }

        DB.searchList = new ArrayList<Recipe>();
        DB1 db1 = new DB1(this);
        Cursor cursor;
        Intent intent;
        switch (arg0.getId()) {
            case R.id.btnOk:
                if (alProducts!=null && !alProducts.isEmpty()) {
                filter = new String[alProducts.size()];
                for (int i = 0; i < alProducts.size(); i++) {
                        filter[i]=(alProducts.get(i));
                } }
                else {
                    filter = new String[1]; filter[0] = "not"; }
                db1.open();
                cursor = db1.getANDFilter(filter);
                DB.setList(cursor,DB.searchList);
                cursor.close();

                Main2Activity.setRecipeList(DB.searchList);
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
        }
        tinyDB.putListString("tinyDBProducts", alProducts);
        tinyDB.putListInt("tinyDBPositions", alPositions);
        finish();
    }
}
