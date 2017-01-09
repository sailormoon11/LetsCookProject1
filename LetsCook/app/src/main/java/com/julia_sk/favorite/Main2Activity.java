
package com.julia_sk.favorite;

        import android.os.Bundle;
        import java.util.ArrayList;
        import android.app.Activity;
        import android.widget.ListView;
        import android.widget.TextView;

public class Main2Activity extends Activity {

    private ListView recipeListView;
    private RecipeListAdapter appListAdapter;
    public static ArrayList<Recipe> recipeList;
    public static void setRecipeList(ArrayList<Recipe> recipeList1) {
        recipeList = recipeList1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if (recipeList==null || recipeList.isEmpty()) {
            TextView textView1 = (TextView) findViewById(R.id.notFavorite);
            textView1.setText("Список пуст");
        }
        recipeListView = (ListView) findViewById(R.id.recipeList);

        appListAdapter = new RecipeListAdapter(this, recipeList);
        recipeListView.setAdapter(appListAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(appListAdapter!=null){
            appListAdapter.notifyDataSetChanged();
        }
    }

}
