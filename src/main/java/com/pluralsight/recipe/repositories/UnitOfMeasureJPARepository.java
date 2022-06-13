package com.pluralsight.recipe.repositories;

import com.pluralsight.recipe.models.Category;
import com.pluralsight.recipe.models.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UnitOfMeasureJPARepository extends JpaRepository<UnitOfMeasure,Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
