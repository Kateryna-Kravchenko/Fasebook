package com.example.katerynakravchenko.fasebook;

import android.app.Application;
import android.content.Intent;

import com.example.katerynakravchenko.fasebook.libs.di.LibsModule;
import com.example.katerynakravchenko.fasebook.login.ui.LoginActivity;
import com.example.katerynakravchenko.fasebook.recipelist.di.DaggerRecipeListComponent;
import com.example.katerynakravchenko.fasebook.recipelist.di.RecipeListComponent;
import com.example.katerynakravchenko.fasebook.recipelist.di.RecipeListModule;
import com.example.katerynakravchenko.fasebook.recipelist.ui.RecipeListActivity;
import com.example.katerynakravchenko.fasebook.recipelist.ui.RecipeListView;
import com.example.katerynakravchenko.fasebook.recipelist.ui.adapters.OnItemClickListener;
import com.example.katerynakravchenko.fasebook.recipemain.di.DaggerRecipeMainComponent;
import com.example.katerynakravchenko.fasebook.recipemain.di.RecipeMainComponent;
import com.example.katerynakravchenko.fasebook.recipemain.di.RecipeMainModule;
import com.example.katerynakravchenko.fasebook.recipemain.ui.RecipeMainActivity;
import com.example.katerynakravchenko.fasebook.recipemain.ui.RecipeMainView;
import com.facebook.login.LoginManager;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by katerynakravchenko on 14.07.17.
 */

public class FacebookRecipesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();


    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initDB() {
        FlowManager.init(this);
    }


    public void logout() {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public RecipeMainComponent getRecipeMainComponent(RecipeMainActivity activity, RecipeMainView view) {
        return DaggerRecipeMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeMainModule(new RecipeMainModule(view))
                .build();
    }

    public RecipeListComponent getRecipeListComponent(RecipeListActivity activity, RecipeListView view, OnItemClickListener onItemClickListener) {
        return DaggerRecipeListComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeListModule(new RecipeListModule(view,onItemClickListener))
                .build();
    }
}
