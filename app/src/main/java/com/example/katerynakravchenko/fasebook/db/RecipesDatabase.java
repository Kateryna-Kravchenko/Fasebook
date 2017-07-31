package com.example.katerynakravchenko.fasebook.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by katerynakravchenko on 14.07.17.
 */
@Database(name =RecipesDatabase.NAME, version = RecipesDatabase.VERSION)
public class RecipesDatabase {
    public static final int VERSION=1;
    public static final String NAME="Recipes";
}
