package com.recipetracker.finalversionrecipetracker.demo.controller.dto;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;


public class RecipeInputDto {
    public String title;
    public String description;
    public boolean isBeef;
    String picturePath;

    public Recipe toRecipe() {
        var recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDescription(description);
        recipe.setBeef(isBeef);
        recipe.setPicturePath(picturePath);
        return recipe;
    }
}
