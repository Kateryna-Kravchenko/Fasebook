package com.example.katerynakravchenko.fasebook.recipelist.ui.adapters;

import com.example.katerynakravchenko.fasebook.entities.Recipe;

/**
 * Created by katerynakravchenko on 31.07.17.
 */

public interface OnItemClickListener {
    void onFavClick(Recipe recipe);
    void onItemClick(Recipe recipe);
    void onDeleteClick(Recipe recipe);
}