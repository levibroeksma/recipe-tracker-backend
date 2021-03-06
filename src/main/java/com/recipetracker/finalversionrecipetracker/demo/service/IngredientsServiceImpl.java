package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.repository.IngredientsRepository;
import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
import com.recipetracker.finalversionrecipetracker.demo.requests.IngredientsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private IngredientsRepository ingredientsRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientsRepository.findAll();
    }

    @Override
    public Ingredient getIngredients(Long id) {
        var optionalIngredients = ingredientsRepository.findById(id);
        if (optionalIngredients.isPresent()) {
            return optionalIngredients.get();
        } else throw new RecordNotFoundException();
    }

    @Override
    public Ingredient saveIngredients(Ingredient ingredient) {
        return ingredientsRepository.save(ingredient);
    }

    @Override
    public void deleteIngredients(Long id) {
        ingredientsRepository.deleteById(id);
    }

    public Ingredient addIngredients(IngredientsRequest ingredientsRequest) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(ingredientsRequest.id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            Ingredient ingredients = new Ingredient();
            ingredients.setName(ingredientsRequest.name);

            ingredients.setRecipe(recipe);
            recipe.getIngredients().add(ingredients);
            recipeRepository.save(recipe);
            return ingredientsRepository.save(ingredients);
        } else throw new RecordNotFoundException();
    }
}