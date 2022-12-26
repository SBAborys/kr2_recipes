package com.example.kr2_recipes.repositories;

import com.example.kr2_recipes.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}