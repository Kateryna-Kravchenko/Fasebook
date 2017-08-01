package com.example.katerynakravchenko.fasebook.recipelist.events;

import com.example.katerynakravchenko.fasebook.entities.Recipe;

import java.util.List;

/**
 * Created by katerynakravchenko on 31.07.17.
 */

public class RecipeListEvent {
    private int type;
    private List<Recipe> recipeList;

    public final static int READ_EVENT = 0;
    public final static int UPDATE_EVENT = 1;
    public final static int DELETE_EVENT = 2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}