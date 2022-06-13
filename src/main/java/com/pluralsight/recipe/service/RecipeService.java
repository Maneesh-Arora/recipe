package com.pluralsight.recipe.service;

import com.pluralsight.recipe.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
}
