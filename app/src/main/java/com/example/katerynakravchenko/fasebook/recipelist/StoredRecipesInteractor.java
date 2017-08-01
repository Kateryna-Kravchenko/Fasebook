package com.example.katerynakravchenko.fasebook.recipelist;

import com.example.katerynakravchenko.fasebook.entities.Recipe;

/**
 * Created by katerynakravchenko on 31.07.17.
 */

public interface StoredRecipesInteractor {
    void executeUpdate(Recipe recipe);
    void executeDelete(Recipe recipe);
}
