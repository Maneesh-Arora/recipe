package com.pluralsight.recipe.repositories;

import com.pluralsight.recipe.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RecipeJPARepository extends JpaRepository<Recipe,Long> {
}
