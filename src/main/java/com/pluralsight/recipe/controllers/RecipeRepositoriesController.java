package com.pluralsight.recipe.controllers;

import com.pluralsight.recipe.models.Recipe;
import com.pluralsight.recipe.repositories.RecipeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeRepositoriesController {

    @Autowired
    RecipeJPARepository repositories;

    @GetMapping
    public List<Recipe> listRecipes(){

        System.out.println("test");
        return repositories.findAll();
    }

    @GetMapping("/{id}")
    public Recipe listRecipes(@PathVariable Long id)
    {
        return repositories.getReferenceById(id);
    }

    @PostMapping("")
    public Recipe createRecipe(@RequestBody Recipe recipe)
    {
        return repositories.saveAndFlush(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe,@PathVariable Long id)
    {
        Recipe found = repositories.getReferenceById(id);
        found.setDescription(recipe.getDescription());
        found.setName(recipe.getName());
        return repositories.saveAndFlush(found);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id)
    {
        List<Recipe> recipes = listRecipes();
        recipes.forEach(recipe -> System.out.println("Recipe ID is " + recipe.getId()));

        Recipe recipe = listRecipes(id);
        System.out.println("Recipe found is " + recipe.getName());
        repositories.deleteById(id);
    }
}
