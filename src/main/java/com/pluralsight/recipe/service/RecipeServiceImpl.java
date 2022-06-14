package com.pluralsight.recipe.service;

import com.pluralsight.recipe.commands.RecipeCommand;
import com.pluralsight.recipe.converters.RecipeCommandToRecipe;
import com.pluralsight.recipe.converters.RecipeToRecipeCommand;
import com.pluralsight.recipe.models.Recipe;
import com.pluralsight.recipe.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeJPARepository recipeJPARepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeJPARepository recipeJPARepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeJPARepository = recipeJPARepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeJPARepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        return recipeJPARepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand)
    {
        Recipe detatchedRecipe = recipeCommandToRecipe.convert(recipeCommand);
        Recipe savedRecipe = recipeJPARepository.save(detatchedRecipe);
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
