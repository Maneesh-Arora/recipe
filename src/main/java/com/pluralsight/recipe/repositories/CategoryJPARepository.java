package com.pluralsight.recipe.repositories;

import com.pluralsight.recipe.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CategoryJPARepository extends JpaRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
}
