package com.example.katerynakravchenko.fasebook.recipemain.di;

import com.example.katerynakravchenko.fasebook.api.RecipeClient;
import com.example.katerynakravchenko.fasebook.api.RecipeService;
import com.example.katerynakravchenko.fasebook.libs.base.EventBus;
import com.example.katerynakravchenko.fasebook.recipemain.GetNextRecipeInteractor;
import com.example.katerynakravchenko.fasebook.recipemain.GetNextRecipeInteractorImpl;
import com.example.katerynakravchenko.fasebook.recipemain.RecipeMainPresenter;
import com.example.katerynakravchenko.fasebook.recipemain.RecipeMainPresenterImpl;
import com.example.katerynakravchenko.fasebook.recipemain.RecipeMainRepository;
import com.example.katerynakravchenko.fasebook.recipemain.RecipeMainRepositoryImpl;
import com.example.katerynakravchenko.fasebook.recipemain.SaveRecipeInteractor;
import com.example.katerynakravchenko.fasebook.recipemain.SaveRecipeInteractorImpl;
import com.example.katerynakravchenko.fasebook.recipemain.ui.RecipeMainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by katerynakravchenko on 28.07.17.
 */
@Module
public class RecipeMainModule {

    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    RecipeMainView providesRecipeMainView(){
        return this.view;
    }

    @Provides @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveInteractor, GetNextRecipeInteractor getNextInteractor){
        return new RecipeMainPresenterImpl(eventBus, view, saveInteractor, getNextInteractor);
    }

    @Provides @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository){
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    GetNextRecipeInteractor providesGetNextRecipeInteractor(RecipeMainRepository repository){
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeMainRepository providesRecipeMainRepository(EventBus eventBus, RecipeService service){
        return new RecipeMainRepositoryImpl(eventBus, service);
    }

    @Provides @Singleton
    RecipeService providesRecipeService(){
        return new RecipeClient().getRecipeService();
    }

}
