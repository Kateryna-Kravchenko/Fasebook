package com.example.katerynakravchenko.fasebook.recipemain.di;

import com.example.katerynakravchenko.fasebook.libs.base.ImageLoader;
import com.example.katerynakravchenko.fasebook.libs.di.LibsModule;
import com.example.katerynakravchenko.fasebook.recipemain.RecipeMainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by katerynakravchenko on 28.07.17.
 */
@Singleton
@Component(modules = {RecipeMainModule.class, LibsModule.class})
public interface RecipeMainComponent {
    //void inject(RecipeMainActivity activity);
    ImageLoader getImageLoader();
    RecipeMainPresenter getPresenter();
}