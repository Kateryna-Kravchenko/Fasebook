package com.example.katerynakravchenko.fasebook.recipelist;

import com.example.katerynakravchenko.fasebook.entities.Recipe;

/**
 * Created by katerynakravchenko on 31.07.17.
 */

public class StoredRecipesInteractorImpl  implements  StoredRecipesInteractor{

    private RecipeListRepository repository;

    public StoredRecipesInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executeUpdate(Recipe recipe) {
        repository.updateRecipe(recipe);
    }

    @Override
    public void executeDelete(Recipe recipe) {
        repository.removeRecipe(recipe);
    }
}
