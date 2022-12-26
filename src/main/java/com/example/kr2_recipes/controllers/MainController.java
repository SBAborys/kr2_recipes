package com.example.kr2_recipes.controllers;

import com.example.kr2_recipes.entities.Country;
import com.example.kr2_recipes.entities.Recipe;
import com.example.kr2_recipes.entities.RecipeIngredient;
import com.example.kr2_recipes.repositories.CountryRepository;
import com.example.kr2_recipes.repositories.RecipeIngredientRepository;
import com.example.kr2_recipes.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private CountryRepository countryRepository;

    private RecipeRepository recipeRepository;

    private RecipeIngredientRepository recipeIngredientRepository;

    @GetMapping("/countries")
    public String showCountries(Model model) {
        List<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        return "countries";
    }

    @GetMapping("/recipes")
    public String showRecipes(Model model) {
        List<Recipe> recipes = recipeRepository.findAll();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/country_recipes/{id}")
    public String recipesByCountry(@PathVariable("id") int id, Model model) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isEmpty()){
            return "redirect:/countries";
        } else {
            model.addAttribute("country", country.get());
            return "recipes_by_country";
        }
    }

    @GetMapping("/recipe_detail/{id}")
    public String recipeDetail(@PathVariable("id") int id,  Model model){
        Optional<RecipeIngredient> ingredients = recipeIngredientRepository.findById(id);
        Optional<Recipe> recipe = recipeRepository.findById(id);
        int portions = 1;
        if (ingredients.isEmpty() || recipe.isEmpty()){
            return "redirect:/countries";
        } else {
            model.addAttribute("ingredients", ingredients.get());
            model.addAttribute("recipe", recipe.get());
            model.addAttribute("portions", portions);
            return "recipes_ingredients";
        }
    }

    @GetMapping("/calculate_quantity")
    public String recipeDetailCalc(@RequestParam int recipe_id,@RequestParam int portions, Model model) {
        Optional<RecipeIngredient> ingredients = recipeIngredientRepository.findById(recipe_id);
        Optional<Recipe> recipe = recipeRepository.findById(recipe_id);
        if (ingredients.isEmpty() || recipe.isEmpty()) {
            return "redirect:/countries";
        } else {
            model.addAttribute("ingredients", ingredients.get());
            model.addAttribute("recipe", recipe.get());
            model.addAttribute("portions", portions);
            return "recipes_ingredients";
        }
    }
}
