package com.pluralsight.recipe.controllers;

import com.pluralsight.recipe.models.Category;
import com.pluralsight.recipe.models.UnitOfMeasure;
import com.pluralsight.recipe.repositories.CategoryJPARepository;
import com.pluralsight.recipe.repositories.UnitOfMeasureJPARepository;
import com.pluralsight.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getRecipes(Model model)
    {
        model.addAttribute("recipes",recipeService.getRecipes());
        return "Index";
    }
}
