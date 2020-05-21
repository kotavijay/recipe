package com.sample.recipe.serivce;

import com.sample.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

}
