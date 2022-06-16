package com.pluralsight.recipe.service;

import com.pluralsight.recipe.commands.RecipeCommand;
import com.pluralsight.recipe.converters.RecipeCommandToRecipe;
import com.pluralsight.recipe.converters.RecipeToRecipeCommand;
import com.pluralsight.recipe.exceptions.NotFoundException;
import com.pluralsight.recipe.models.Recipe;
import com.pluralsight.recipe.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
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
        Optional<Recipe> recipeOptional = recipeJPARepository.findById(id);
        if(!recipeOptional.isPresent())
        {
            throw new NotFoundException("Recipe Not Found");
        }
        return recipeOptional.get();
    }

    @Transactional
    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand)
    {
        Recipe detatchedRecipe = recipeCommandToRecipe.convert(recipeCommand);
        Recipe savedRecipe = recipeJPARepository.save(detatchedRecipe);
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeJPARepository.deleteById(idToDelete);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }
}
