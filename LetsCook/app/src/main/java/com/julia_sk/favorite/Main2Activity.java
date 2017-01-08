
package com.julia_sk.favorite;

        import android.os.Bundle;
        import java.util.ArrayList;
        import android.app.Activity;
        import android.widget.ListView;

public class Main2Activity extends Activity {

    private ListView lessonListView;
    private RecipeListAdapter appListAdapter;
    public static ArrayList<Recipe> lessonsList;
    public static void setLessonsList(ArrayList<Recipe> lessonsList1) {
        lessonsList = lessonsList1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lessonListView = (ListView) findViewById(R.id.recipeList);

        appListAdapter = new RecipeListAdapter(this, lessonsList);
        lessonListView.setAdapter(appListAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(appListAdapter!=null){
            appListAdapter.notifyDataSetChanged();
        }
    }

}
