package com.sample.recipe.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;
    Recipe recipe;

    @BeforeEach
    public void setUp(){
        category = new Category();
        recipe = new Recipe();
    }

    @Test
    void getId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue,category.getId());
    }
    @Test
    void getDescription() {
        String description = "sample JUnit description";
        category.setDescription(description);
        assertEquals(description,category.getDescription());
    }
    @Test
    void getRecipes() { 
        Set<Recipe> recipes = new HashSet<>();
        category.setRecipes(recipes);
        assertEquals(recipes,category.getRecipes());
    }

}