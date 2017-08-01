package com.example.katerynakravchenko.fasebook.recipelist.di;

import com.example.katerynakravchenko.fasebook.libs.di.LibsModule;
import com.example.katerynakravchenko.fasebook.recipelist.RecipeListPresenter;
import com.example.katerynakravchenko.fasebook.recipelist.ui.adapters.RecipesAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by katerynakravchenko on 28.07.17.
 */
@Singleton
@Component(modules = {RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {
    //void inject(RecipeMainActivity activity);
    RecipesAdapter getAdapter();
    RecipeListPresenter getPresenter();
}