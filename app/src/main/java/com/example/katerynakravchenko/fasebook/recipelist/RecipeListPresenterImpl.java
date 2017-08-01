package com.example.katerynakravchenko.fasebook.recipelist;

import com.example.katerynakravchenko.fasebook.entities.Recipe;
import com.example.katerynakravchenko.fasebook.libs.base.EventBus;
import com.example.katerynakravchenko.fasebook.recipelist.events.RecipeListEvent;
import com.example.katerynakravchenko.fasebook.recipelist.ui.RecipeListView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by katerynakravchenko on 31.07.17.
 */

public class RecipeListPresenterImpl implements RecipeListPresenter {
    private EventBus eventBus;
    private RecipeListInteractor listInteractor;
    private RecipeListView view;
    private StoredRecipesInteractor storedRecipesInteractor;

    public RecipeListPresenterImpl(EventBus eventBus, RecipeListInteractor listInteractor, RecipeListView view, StoredRecipesInteractor storedRecipesInteractor) {
        this.eventBus = eventBus;
        this.listInteractor = listInteractor;
        this.view = view;
        this.storedRecipesInteractor = storedRecipesInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(true);
        view = null;
    }

    @Override
    public void getRecipe() {

        listInteractor.execute();
    }

    @Override
    public void removeRecipe(Recipe recipe) {

        storedRecipesInteractor.executeDelete(recipe);
    }

    @Override
    public void toggleFavorite(Recipe recipe) {
        boolean fav= recipe.getFavorite();
        recipe.setFavorite(!fav);
        storedRecipesInteractor.executeUpdate(recipe);

    }

    @Override
    @Subscribe
    public void onEventMainThread(RecipeListEvent event) {
        if (this.view != null) {
            switch (event.getType()) {
                case RecipeListEvent.READ_EVENT:
                    view.setRecipes(event.getRecipeList());
                    break;
                case RecipeListEvent.UPDATE_EVENT:
                    view.recipeUpdated();
                    break;
                case RecipeListEvent.DELETE_EVENT:
                    Recipe recipe = event.getRecipeList().get(0);
                    view.recipeDeleted(recipe);
                    break;
            }
        }

    }

    @Override
    public RecipeListView getView() {
        return null;
    }
}
