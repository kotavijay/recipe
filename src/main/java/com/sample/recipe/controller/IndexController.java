package com.sample.recipe.controller;

import com.sample.recipe.serivce.RecipeService;
import com.sample.recipe.serivce.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Entered into :: " + IndexController.class + " :: getIndexPage()");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

}
