package com.example.katerynakravchenko.fasebook.recipelist.di;

import com.example.katerynakravchenko.fasebook.entities.Recipe;
import com.example.katerynakravchenko.fasebook.libs.base.ImageLoader;
import com.example.katerynakravchenko.fasebook.recipelist.RecipeListInteractor;
import com.example.katerynakravchenko.fasebook.recipelist.RecipeListInteractorImpl;
import com.example.katerynakravchenko.fasebook.recipelist.RecipeListPresenter;
import com.example.katerynakravchenko.fasebook.recipelist.RecipeListPresenterImpl;
import com.example.katerynakravchenko.fasebook.recipelist.RecipeListRepository;
import com.example.katerynakravchenko.fasebook.recipelist.RecipeListRepositoryImpl;
import com.example.katerynakravchenko.fasebook.recipelist.StoredRecipesInteractor;
import com.example.katerynakravchenko.fasebook.recipelist.StoredRecipesInteractorImpl;
import com.example.katerynakravchenko.fasebook.recipelist.ui.RecipeListView;
import com.example.katerynakravchenko.fasebook.recipelist.ui.adapters.OnItemClickListener;
import com.example.katerynakravchenko.fasebook.recipelist.ui.adapters.RecipesAdapter;
import com.example.katerynakravchenko.fasebook.libs.base.EventBus;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by katerynakravchenko on 28.07.17.
 */
@Module
public class RecipeListModule {
    RecipeListView view;
    OnItemClickListener clickListener;

    public RecipeListModule(RecipeListView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    RecipeListView providesRecipeListView(){
        return this.view;
    }

    @Provides @Singleton
    RecipeListPresenter providesRecipeListPresenter(EventBus eventBus, RecipeListView view,
                                                    RecipeListInteractor listInteractor,
                                                    StoredRecipesInteractor storedInteractor){

        return new RecipeListPresenterImpl(eventBus, listInteractor, view, storedInteractor);
    }

    @Provides @Singleton
    StoredRecipesInteractor providesStoredRecipesInteractor(RecipeListRepository repository){
        return new StoredRecipesInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListInteractor providesRecipeListInteractor(RecipeListRepository repository){
        return new RecipeListInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListRepository providesRecipeListRepository(EventBus eventBus){
        return new RecipeListRepositoryImpl(eventBus);
    }

    @Provides @Singleton
    RecipesAdapter providesRecipesAdapter(List<Recipe> recipeList, ImageLoader imageLoader, OnItemClickListener onItemClickListener){
        return new RecipesAdapter(recipeList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides @Singleton
    List<Recipe> providesEmptyList(){
        return new ArrayList<Recipe>();
    }
}