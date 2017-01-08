package com.julia_sk.favorite;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Test on 08.12.2016.
 */

public class DB {
    public static ArrayList<Recipe> recipeList; //мясо
    public static ArrayList<Recipe> recipeList2; //рыбв и морепродукты
    public static ArrayList<Recipe> allResipes;
    public static ArrayList<Recipe> searchList;
    public static ArrayList<Recipe> milk;
    public static ArrayList<Recipe> Macarons;
    public static ArrayList<Recipe> Semimanufactures;
    public static ArrayList<Recipe> Fruits;
    public static ArrayList<Recipe> Other;
    public static ArrayList<Recipe> favoriteList;
    public static String[] favoriteString;
    public DB() {
    }

public static void setList(Cursor cursor, ArrayList<Recipe> list)
{
    if (cursor.moveToFirst()) {
        int idIndex = cursor.getColumnIndex(DB1.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DB1.KEY_TITLE);
        int textIndex = cursor.getColumnIndex(DB1.KEY_RECIPETEXT);
        int complexityIndex = cursor.getColumnIndex(DB1.KEY_COMPLEXITY);
        int timeIndex = cursor.getColumnIndex(DB1.KEY_COOKINGTIMEMIN);
        int productsIndex = cursor.getColumnIndex(DB1.KEY_PRODUCTS);
        do {
            list.add(new Recipe("Рецепт " + cursor.getInt(idIndex) + " " + cursor.getString(nameIndex) ,
                    "\nПродукты: " + cursor.getString(productsIndex)
                    + "\n" + cursor.getString(complexityIndex)
                    + "\nВремя: " + cursor.getString(timeIndex) + "\n" + cursor.getString(textIndex)));
            list.get(cursor.getPosition()).setId(cursor.getInt(idIndex));
            Log.d("mLog", "ID = " + cursor.getPosition());
        } while (cursor.moveToNext());
    }
}
    public static void save(Recipe recipe) {
        Boolean contain = false;
        if (favoriteList == null) {
            favoriteList = new ArrayList<Recipe>();
        }
        for (int i=0;i<favoriteList.size();i++) {
            if (favoriteList.get(i).getId()== recipe.getId()) {
                contain = true;
                break;
            }
        }
        if (!contain)
            favoriteList.add(recipe);
    }

    public static void delete(Recipe recipe) { favoriteList.remove(recipe); }

    public static String getFavoritrList() {
        String s="";
        for (int i =0; i<favoriteList.size();i++)
            s+=(favoriteList.get(i).getId().toString() + " ");
        return s; }

    public static void setFavoritrList2() {
        if (favoriteList==null) {
            favoriteString = new String[1];
            favoriteString[0] = "Список пуст";
        }
        else {
            favoriteString = new String[favoriteList.size()];
            for (int i =0; i<favoriteList.size();i++)
                favoriteString[i] = favoriteList.get(i).getTitle();
            }
        }




}
