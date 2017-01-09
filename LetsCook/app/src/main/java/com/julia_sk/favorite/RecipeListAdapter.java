package com.julia_sk.favorite;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Юлия on 25.11.2016.
 */

import android.view.View.OnClickListener;

public class RecipeListAdapter extends BaseAdapter
{
    //public static Vector<Integer> favoriteList;
    private Context context;
    private ArrayList<Recipe> recipeList;
    private LayoutInflater inflater;

    public RecipeListAdapter(Context context, ArrayList<Recipe> recipeList)
    {
        this.context = context;
        this.recipeList = (ArrayList<Recipe>)recipeList.clone();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return recipeList.size();
    }

    @Override
    public Recipe getItem(int position)
    {
        return recipeList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent)
    {
        View view = null;
        ViewHolder viewHolder;

        if (v == null){
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.recipe_item, parent, false);
            viewHolder.tvRecipeName = (TextView) view.findViewById(R.id.tvRecipeItem);
            viewHolder.chbFaforiteLesson = (CheckBox) view.findViewById(R.id.chbFavoriteRecipe);
            viewHolder.tvRecipeName.setOnClickListener(onClick);
            viewHolder.chbFaforiteLesson.setOnClickListener(onClick);

            view.setTag(viewHolder);
        } else {
            view = v;
            viewHolder = (ViewHolder) view.getTag();
        }
        Recipe recipe = recipeList.get(position);

        viewHolder.tvRecipeName.setTag(position);
        viewHolder.chbFaforiteLesson.setTag(position);

        viewHolder.tvRecipeName.setText(recipe.getTitle());
        viewHolder.chbFaforiteLesson.setChecked(recipe.isFavorite());

        return view;
    }

    static class ViewHolder {
        private TextView tvRecipeName;
        private CheckBox chbFaforiteLesson;
    }

//    public void save(int position) {
//        if (favoriteList == null) {
//            favoriteList = new Vector<Integer>();
//        }
//
//        if (!favoriteList.contains(position))
//            this.favoriteList.add(position); }
//
//    public void delete(int position) { this.favoriteList.remove((Object)position); }
//
//    public String getFavoritrList() { return this.favoriteList.toString(); }

    OnClickListener onClick = new OnClickListener(){

        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.tvRecipeItem:
                    Intent intent = new Intent(context, RecipeActivity.class);
                    intent.putExtra("position", (Integer) view.getTag());
                    context.startActivity(intent);
                    break;

                case R.id.chbFavoriteRecipe:
                    recipeList.get((Integer) view.getTag()).setFavorite(((CheckBox) view).isChecked());
                    if (((CheckBox) view).isChecked()) {
                        DB.save(recipeList.get((Integer) view.getTag()));
                    }
                    else {
                        //recipeList.get((Integer) view.getTag());
                        DB.delete(recipeList.get((Integer) view.getTag()));

                    }
                    Log.d("sd",recipeList.get((Integer) view.getTag()).getTitle());
                    Log.d("sd",DB.getFavoritrList());
                    break;
            }

        }

    };


}