package com.example.kr2_recipes.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "recipe_name", nullable = false, length = 100)
    private String recipe_name;

    @Column(name = "cooking_info", nullable = false, length = 10_000)
    private String cooking_info;

    @Column(name = "recipe_image", nullable = false, length = 10_000)
    private String recipe_image;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

//    @OneToMany(orphanRemoval = true)
//    @JoinColumn(name = "recipe_id")
//    private Set<RecipeIngredient> recipeInformation = new LinkedHashSet<>();
//
//    public Set<RecipeIngredient> getRecipeInformation() {
//        return recipeInformation;
//    }

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "recipe_id")
    private List<RecipeIngredient> recipeInformation = new ArrayList<>();

    public List<RecipeIngredient> getRecipeInformation() {
        return recipeInformation;
    }

    public void setRecipeInformation(List<RecipeIngredient> recipeInformation) {
        this.recipeInformation = recipeInformation;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCooking_info() {
        return cooking_info;
    }

    public void setCooking_info(String cooking_info) {
        this.cooking_info = cooking_info;
    }

    public String getRecipe_image() {
        return recipe_image;
    }

    public void setRecipe_image(String recipe_image) {
        this.recipe_image = recipe_image;
    }

    @Override
    public String toString() {
        return recipe_name;
    }
}