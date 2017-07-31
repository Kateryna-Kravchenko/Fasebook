package com.example.katerynakravchenko.fasebook.api;

import com.example.katerynakravchenko.fasebook.entities.Recipe;

import java.util.List;

/**
 * Created by katerynakravchenko on 14.07.17.
 */

public class RecipeSearchResponse {
    private int count;
    private List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Recipe getFirstRecipe(){
        Recipe first = null;
        if (!recipes.isEmpty()) {
            first = recipes.get(0);
        }
        return first;
    }
}