package com.pluralsight.recipe.service;

import com.pluralsight.recipe.models.Recipe;
import com.pluralsight.recipe.repositories.RecipeJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeJPARepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(repository);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        ArrayList<Recipe> list =new ArrayList<>(); //Creation of ArrayList
        list.addAll(recipeData); //HashSet to ArrayList


        when(repository.findAll()).thenReturn(list);

        Set<Recipe> recipes_r =  recipeService.getRecipes();
        assertEquals(recipes_r.size(),1);
        verify(repository,times(1)).findAll();
    }
}