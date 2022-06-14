package com.pluralsight.recipe.service;

import com.pluralsight.recipe.converters.RecipeCommandToRecipe;
import com.pluralsight.recipe.converters.RecipeToRecipeCommand;
import com.pluralsight.recipe.models.Recipe;
import com.pluralsight.recipe.repositories.RecipeJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeJPARepository repository;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(repository, recipeCommandToRecipe, recipeToRecipeCommand);
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

    @Test
    public void getRecipeByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

       when(repository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipes_r =  recipeService.findById(1L);
        assertNotNull(recipes_r);
        verify(repository,times(1)).findById(anyLong());
        verify(repository,never()).findAll();

    }

    @Test
    public void testDeleteById() throws Exception {

        //given
        Long idToDelete = Long.valueOf(2L);

        //when
        recipeService.deleteById(idToDelete);

        //no 'when', since method has void return type

        //then
        verify(repository, times(1)).deleteById(anyLong());
    }
}