package com.example.katerynakravchenko.fasebook.recipemain;

import com.example.katerynakravchenko.fasebook.entities.Recipe;
import com.example.katerynakravchenko.fasebook.recipemain.events.RecipeMainEvent;
import com.example.katerynakravchenko.fasebook.recipemain.ui.RecipeMainView;

/**
 * Created by katerynakravchenko on 18.07.17.
 */

public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void imageError(String error);
    void imageReady();
    void saveRecipe(Recipe recipe);
    void onEventMainThread(RecipeMainEvent event);

    RecipeMainView getView();
}