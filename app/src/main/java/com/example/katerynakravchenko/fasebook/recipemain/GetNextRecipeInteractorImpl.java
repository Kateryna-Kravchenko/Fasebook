package com.example.katerynakravchenko.fasebook.recipemain;

import java.util.Random;

/**
 * Created by katerynakravchenko on 28.07.17.
 */


public class GetNextRecipeInteractorImpl implements GetNextRecipeInteractor {
    RecipeMainRepository repository;

    public GetNextRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        int recipePage = new Random().nextInt(RecipeMainRepository.RECIPE_RANGE);
        repository.setrecipePage(recipePage);
        repository.getNextRecipe();
    }
}