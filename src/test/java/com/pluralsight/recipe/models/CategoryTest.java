package com.pluralsight.recipe.models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setup()
    {
        category = new Category();
    }
    @Test
    void getId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    void getRecipes() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void setId() {
    }

    @Test
    void setRecipes() {
    }

    @Test
    void setDescription() {
    }
}