package com.pluralsight.recipe.service;

import com.pluralsight.recipe.models.Recipe;
import com.pluralsight.recipe.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeJPARepository recipeJPARepository;

    public RecipeServiceImpl(RecipeJPARepository recipeJPARepository) {
        this.recipeJPARepository = recipeJPARepository;
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
}
