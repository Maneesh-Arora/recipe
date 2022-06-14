package com.pluralsight.recipe.service;

import com.pluralsight.recipe.commands.RecipeCommand;
import com.pluralsight.recipe.models.Recipe;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
