package com.example.katerynakravchenko.fasebook.recipelist;

import com.example.katerynakravchenko.fasebook.entities.Recipe;
import com.example.katerynakravchenko.fasebook.recipelist.events.RecipeListEvent;
import com.example.katerynakravchenko.fasebook.recipelist.ui.RecipeListView;

/**
 * Created by katerynakravchenko on 31.07.17.
 */

public interface RecipeListPresenter {
    void onCreate();

    void onDestroy();

    void getRecipe();

    void removeRecipe(Recipe recipe);

    void toggleFavorite(Recipe recipe);
    void onEventMainThread(RecipeListEvent event );

    RecipeListView getView();
}
