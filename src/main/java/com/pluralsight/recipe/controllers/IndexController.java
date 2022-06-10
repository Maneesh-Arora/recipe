package com.pluralsight.recipe.controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","/index","/index.html"})
    public String getRecipes()
    {
        System.out.println("Testing");
        return "Index";
    }
}
