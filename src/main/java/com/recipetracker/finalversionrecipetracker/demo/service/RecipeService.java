package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getRecipes();

    Recipe getRecipe(Long id);

    Recipe saveRecipe(Recipe recipe);

    void deleteRecipe(Long id);

}
