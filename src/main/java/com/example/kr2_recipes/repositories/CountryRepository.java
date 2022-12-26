package com.example.kr2_recipes.repositories;

import com.example.kr2_recipes.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Integer> {
}