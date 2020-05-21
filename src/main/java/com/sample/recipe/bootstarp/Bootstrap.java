package com.sample.recipe.bootstarp;

import com.sample.recipe.domain.*;
import com.sample.recipe.repository.CategoryRepository;
import com.sample.recipe.repository.RecipeRepository;
import com.sample.recipe.repository.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();

//        Get UnitOfMeasures
        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!teaspoonUomOptional.isPresent())
            throw new RuntimeException("Expected UOM not found...!!!");

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!tablespoonUomOptional.isPresent())
            throw new RuntimeException("Expected UOM not found...!!!");

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (!cupUomOptional.isPresent())
            throw new RuntimeException("Expected UOM not found...!!!");

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if (!pinchUomOptional.isPresent())
            throw new RuntimeException("Expected UOM not found...!!!");

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if (!ounceUomOptional.isPresent())
            throw new RuntimeException("Expected UOM not found...!!!");

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (!eachUomOptional.isPresent())
            throw new RuntimeException("Expected UOM not found...!!!");

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (!dashUomOptional.isPresent())
            throw new RuntimeException("Expected UOM not found...!!!");

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if (!pintUomOptional.isPresent())
            throw new RuntimeException("Expected UOM not found...!!!");

//        Get Optionals
        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();

//        Get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if (!americanCategoryOptional.isPresent())
            throw new RuntimeException("Expected Category not found...!!!");

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (!mexicanCategoryOptional.isPresent())
            throw new RuntimeException("Expected Category not found...!!!");

//        Get Optionals
        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

//        Perfect Guacamole Recipe
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole Recipe");
        guacamoleRecipe.setPreTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setServings(2);
//        Ignore Source field
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the" +
                " avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl" +
                ".\n\n2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little " +
                "chunky.)\n\n3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime " +
                "juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilies. Chili peppers vary individually in their hotness. So, start " +
                "with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe " +
                "and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving" +
                ".\n\n4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and " +
                "press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the " +
                "guacamole brown.) Refrigerate until ready to serve.");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
//        Ignore Image field

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Once you have basic guacamole down, feel free to experiment with variations including " +
                "strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and " +
                "chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!\n" +
                "\n" +
                "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of " +
                "availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your " +
                "guacamole dip. Purists may be horrified, but so what? It tastes great.");
        guacamoleNotes.setRecipe(guacamoleRecipe);

        guacamoleRecipe.setNotes(guacamoleNotes);
        guacamoleRecipe.getIngredient().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom, guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("teaspoon of salt, more to taste", new BigDecimal(1 / 4), teaspoonUom,
                guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tablespoonUom,
                guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2),
                tablespoonUom, guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("serrano chilies, stems and seeds removed, minced", new BigDecimal(2), eachUom
                , guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2),
                tablespoonUom, guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUom, guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(1 / 2), eachUom
                , guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("Red radishes or jicama, to garnish", new BigDecimal(1), eachUom,
                guacamoleRecipe));
        guacamoleRecipe.getIngredient().add(new Ingredient("Tortilla chips, to serve", new BigDecimal(1), eachUom, guacamoleRecipe));

        guacamoleRecipe.getCategories().add(americanCategory);
        guacamoleRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacamoleRecipe);

        return recipes;
    }

}
