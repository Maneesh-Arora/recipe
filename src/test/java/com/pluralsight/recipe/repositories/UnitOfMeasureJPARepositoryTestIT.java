package com.pluralsight.recipe.repositories;

import com.pluralsight.recipe.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureJPARepositoryTestIT {

    @Autowired
    UnitOfMeasureJPARepository unitOfMeasureJPARepository;

    @Before
    public void setUp() throws Exception{

    }

    @Test
    void findByDescription() {
        Optional<UnitOfMeasure> uom = unitOfMeasureJPARepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon",uom.get().getDescription());
    }

    @Test
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> uom = unitOfMeasureJPARepository.findByDescription("Cup");
        assertEquals("Cup",uom.get().getDescription());
    }

    @org.junit.Test
    public void testFindByDescription() {
    }
}