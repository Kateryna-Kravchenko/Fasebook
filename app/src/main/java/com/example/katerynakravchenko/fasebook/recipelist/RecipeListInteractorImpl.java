package com.example.katerynakravchenko.fasebook.recipelist;

/**
 * Created by katerynakravchenko on 31.07.17.
 */

public class RecipeListInteractorImpl  implements RecipeListInteractor{
    private RecipeListRepository repository;

    public RecipeListInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipe();
    }
}
