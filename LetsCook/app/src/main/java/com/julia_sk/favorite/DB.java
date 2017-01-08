package com.julia_sk.favorite;

import java.util.ArrayList;

/**
 * Created by Test on 08.12.2016.
 */

public class DB {
    public ArrayList<Recipe> recipeList;
    public ArrayList<Recipe> recipeList2;
    public ArrayList<Recipe> allRecipes;
    //public static Vector<Integer> favoriteList;
    public static ArrayList<Recipe> favoriteList;
    public static String[] favoriteString;


    public DB() {
        recipeList = new ArrayList<Recipe>();
        recipeList2 = new ArrayList<Recipe>();
        allRecipes = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            recipeList.add(new Recipe("Рецепт " + i, "Текст рецепта про мясо ..." ));
            recipeList.get(i-1).setId(i);
        }
        for (int i = 1; i < 11; i++) {
            recipeList2.add(new Recipe("Рецепт " + (i+11), "Текст рецепта пор морепродукты ... " ));
            recipeList2.get(i-1).setId(i+11);
        }
        allRecipes.addAll(recipeList);
        allRecipes.addAll(recipeList2);
    }

//    public static void save(int position) {
//        if (favoriteList == null) {
//            favoriteList = new Vector<Integer>();
//        }
//
//        if (!favoriteList.contains(position))
//            favoriteList.add(position); }
//
//    public static void delete(int position) { favoriteList.remove((Object)position); }
//
//    public static String getFavoritrList() { return favoriteList.toString(); }
//
//    public ArrayList<Recipe> createFavoriteList() {
//        favorite = new ArrayList<Recipe>();
//        for (int i = 0; i < favoriteList.size(); i++) {
//            for (int j =0; j<recipeList.size(); j++) {
//                if (recipeList.get(j).getId()==favorite.get(i))
//            }
//            if (favoriteList.get(i)<11)
//                favorite.add(recipeList.get(favoriteList.get(i)));
//            else
//                favorite.add(recipeList2.get(favoriteList.get(i)));
//        }
//        return favorite;
//    }

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
        favoriteString = new String[favoriteList.size()];
        for (int i =0; i<favoriteList.size();i++)
            favoriteString[i] = favoriteList.get(i).getTitle();
         }


}
