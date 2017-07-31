package com.example.katerynakravchenko.fasebook.recipemain;

import com.example.katerynakravchenko.fasebook.entities.Recipe;

/**
 * Created by katerynakravchenko on 18.07.17.
 */

public interface RecipeMainRepository {
    public final static int COUNT = 1;
    public final static String RECENT_SORT = "r";
    public final static int RECIPE_RANGE = 100000;

    void getNextRecipe();

    void saveRecipe(Recipe recipe);

    void setrecipePage(int recipePage);


}
