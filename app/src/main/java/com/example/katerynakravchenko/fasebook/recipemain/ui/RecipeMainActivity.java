package com.example.katerynakravchenko.fasebook.recipemain.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.katerynakravchenko.fasebook.FacebookRecipesApp;
import com.example.katerynakravchenko.fasebook.R;
import com.example.katerynakravchenko.fasebook.recipelist.ui.RecipeListActivity;
import com.example.katerynakravchenko.fasebook.entities.Recipe;
import com.example.katerynakravchenko.fasebook.libs.base.ImageLoader;
import com.example.katerynakravchenko.fasebook.recipemain.RecipeMainPresenter;
import com.example.katerynakravchenko.fasebook.recipemain.di.RecipeMainComponent;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RecipeMainActivity extends AppCompatActivity implements RecipeMainView {

        @Bind(R.id.imgRecipe)
        ImageView imgRecipe;
        @Bind(R.id.imgDismiss)
        ImageButton imgDismiss;
        @Bind(R.id.imgKeep)
        ImageButton imgKeep;
        @Bind(R.id.progressBar)
        ProgressBar progressBar;
        @Bind(R.id.layoutContainer)
        RelativeLayout layoutContainer;

        private Recipe currentRecipe;
        private ImageLoader imageLoader;
        private RecipeMainPresenter presenter;
        private RecipeMainComponent component;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recipe_main);
            ButterKnife.bind(this);
            setupInjection();
            setupImageLoader();
            presenter.onCreate();
            presenter.getNextRecipe();
        }


        private void setupImageLoader() {
            RequestListener glideRequestListener = new RequestListener() {
                @Override
                public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
                    presenter.imageError(e.getLocalizedMessage());
                    return false;
                }

                @Override
                public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache, boolean isFirstResource) {
                    presenter.imageReady();
                    return false;
                }
            };
            imageLoader.setOnFinishedImageLoadingListener(glideRequestListener);
        }

        @Override
        protected void onDestroy() {
            presenter.onDestroy();
            super.onDestroy();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_recipes_main, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.action_list) {
                navigateToListScreen();
            } else if (id == R.id.action_logout) {
                logout();
            }
            return super.onOptionsItemSelected(item);
        }

        private void logout() {
            FacebookRecipesApp app = (FacebookRecipesApp)getApplication();
            app.logout();
        }

        private void navigateToListScreen() {
            startActivity(new Intent(this, RecipeListActivity.class));
        }

        private void setupInjection() {
            FacebookRecipesApp app = (FacebookRecipesApp)getApplication();
            component= app.getRecipeMainComponent(this,this);
            imageLoader = getImageLoader();
            presenter = getPresenter();
        }

        @Override
        public void showProgress() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void hideProgress() {
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void showUIElements() {
            imgKeep.setVisibility(View.VISIBLE);
            imgDismiss.setVisibility(View.VISIBLE);
        }

        @Override
        public void hideUIElements() {
            imgKeep.setVisibility(View.GONE);
            imgDismiss.setVisibility(View.GONE);
        }

    @Override
    public void saveAnimation() {

    }

    @Override
    public void dismissAnimation() {

    }

    private void clearImage(){
            imgRecipe.setImageResource(0);
        }


        @OnClick(R.id.imgKeep)
        public void onKeep() {
            if (currentRecipe != null) {
                presenter.saveRecipe(currentRecipe);
            }
        }


        @OnClick(R.id.imgDismiss)
        public void onDismiss() {
            presenter.dismissRecipe();
        }

        @Override
        public void onRecipeSaved() {
            Snackbar.make(layoutContainer, R.string.recipemain_notice_saved, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void setRecipe(Recipe recipe) {
            this.currentRecipe = recipe;
            imageLoader.load(imgRecipe, recipe.getImageURL());
        }

        @Override
        public void onGetRecipeError(String error) {
            String msgError = String.format(getString(R.string.recipemain_error), error);
            Snackbar.make(layoutContainer, msgError, Snackbar.LENGTH_SHORT).show();
        }

        public ImageLoader getImageLoader() {

            return component.getImageLoader();
        }

        public RecipeMainPresenter getPresenter() {
            return component.getPresenter();
        }
    }