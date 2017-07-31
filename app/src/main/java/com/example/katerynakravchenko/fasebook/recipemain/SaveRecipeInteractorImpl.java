package com.example.katerynakravchenko.fasebook.recipemain;

import com.example.katerynakravchenko.fasebook.entities.Recipe;

/**
 * Created by katerynakravchenko on 28.07.17.
 */

public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {


    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}

