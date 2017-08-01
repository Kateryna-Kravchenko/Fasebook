package com.example.katerynakravchenko.fasebook.recipelist.ui;

import com.example.katerynakravchenko.fasebook.entities.Recipe;

import java.util.List;

/**
 * Created by katerynakravchenko on 31.07.17.
 */

public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdated();
    void recipeDeleted(Recipe recipe);
}
